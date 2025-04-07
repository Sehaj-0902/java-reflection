package com.bridgelabz.basicproblems;

import java.lang.reflect.Field;

class Person {
    private int age = 20;
}
public class AccessPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Person person = new Person();
        Class<?> cls = person.getClass();

        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Old age:" + field.get(person));

        field.set(person, 22);
        System.out.println("New age: " + field.get(person));
    }
}

/*
Output:
    Old age:20
    New age: 22
 */