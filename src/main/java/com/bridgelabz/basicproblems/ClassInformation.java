package com.bridgelabz.basicproblems;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
    private int rollNumber;
    private String name;
    private String department;

    public Student(int rollNumber, String name, String department) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
    }

    private void displayStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}

public class ClassInformation {
    public static void main(String[] args) throws Exception {
        Student student = new Student(1296, "Sehaj", "CSE");
        Class<?> cls = student.getClass();

        System.out.println("Accessing Class Fields:");
        Field field1 = cls.getDeclaredField("rollNumber");
        field1.setAccessible(true);
        System.out.println("Roll Number: " + field1.get(student));

        Field field2 = cls.getDeclaredField("name");
        field2.setAccessible(true);
        System.out.println("Name: " + field2.get(student));

        System.out.println("\nAccessing Class Method:");
        Method method = cls.getDeclaredMethod("displayStudentDetails");
        method.setAccessible(true);
        method.invoke(student);

        System.out.println("\nAccessing Class Constructor:");
        Constructor<?> constructor = cls.getDeclaredConstructor(int.class, String.class, String.class);
        System.out.println(constructor);
    }
}

/*
Output:
    Accessing Class Fields:
    Roll Number: 1296
    Name: Sehaj

    Accessing Class Method:
    Student Details:
    Roll Number: 1296
    Name: Sehaj
    Department: CSE

    Accessing Class Constructor:
    public com.bridgelabz.basicproblems.Student(int,java.lang.String,java.lang.String)
 */