package com.gmail.tsikalenko.nikita;

import java.lang.reflect.Method;

public class Saver {
	public static void save(Class<?>... cl) {
		for (Class<?> cls : cl) {
			if(cls.isAnnotationPresent(SaveTo.class)) {
				Method[] m = cls.getDeclaredMethods();
				for (Method method : m) {
					if(method.isAnnotationPresent(Save.class)) {
						try {
						TextContainer tc = new TextContainer();
						SaveTo anCl = cls.getAnnotation(SaveTo.class);
						method.invoke(tc, anCl.file());
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
