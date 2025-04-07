package com.bridgelabz.basicproblems;

import java.lang.reflect.Constructor;

class StudentInfo {
    private String name;

    public StudentInfo(String name) {
        this.name = name;
    }

    public void displayName() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = StudentInfo.class;

        Constructor<?> constructor = cls.getConstructor(String.class);
        StudentInfo student = (StudentInfo) constructor.newInstance("Sehaj");

        student.displayName();
    }
}

/*
Output:
    Student Name: Sehaj
*/