package com.bridgelabz.intermediateproblems;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "123Api-keY";
}

public class AccessModifyStaticField {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Class<?> cls = configuration.getClass();

        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        System.out.println("Original Key: " + field.get(configuration));

        field.set(field,"456Api-keY");
        System.out.println("Modified Key: " + field.get(configuration));
    }
}

/*
Output:
    Original Key: 123Api-keY
    Modified Key: 456Api-keY
 */