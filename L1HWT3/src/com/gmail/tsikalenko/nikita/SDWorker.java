package com.gmail.tsikalenko.nikita;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

public class SDWorker {
    public static String serialize(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();
        Field[] f = cls.getDeclaredFields();
        for (Field field : f) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }

                sb.append(field.getName() + "=");
                if (field.getType() == int.class) {
                    sb.append(field.getInt(o));
                } else if (field.getType() == String.class) {
                    sb.append((String) field.get(o));
                } else if (field.getType() == long.class) {
                    sb.append(field.getLong(o));
                }

                sb.append(";");
            }
        }

        return sb.toString();
    }

    public static <T> T deserialize(String s, Class<T> cls) throws InstantiationException, NoSuchFieldException, IllegalAccessException {
        T newT = (T) cls.newInstance();

        String[] ns = s.split(";");

        for (String string : ns) {
            String[] nv = string.split("=");
            if (nv.length != 2) {
                throw new InvalidParameterException();
            }

            Field f = cls.getDeclaredField(nv[0]);

            if (Modifier.isPrivate(f.getModifiers())) {
                f.setAccessible(true);
            }
            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == int.class) {
                    f.setInt(newT, Integer.parseInt(nv[1]));
                } else if (f.getType() == String.class) {
                    f.set(newT, nv[1]);
                } else if (f.getType() == long.class) {
                    f.setLong(newT, Long.parseLong(nv[1]));
                }
            }
        }

        return newT;
    }
}
