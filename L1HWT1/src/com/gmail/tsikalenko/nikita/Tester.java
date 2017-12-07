package com.gmail.tsikalenko.nikita;

import java.lang.reflect.Method;

public class Tester {
	public static void test(Class<?>... cl) {
		try {
			for(Class<?> cls : cl) {
				Method[] method = cls.getDeclaredMethods();
				for (Method m : method) {
					if(m.isAnnotationPresent(Test.class)) {
						Test an = m.getAnnotation(Test.class);
						m.invoke(null, an.a(), an.b());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
