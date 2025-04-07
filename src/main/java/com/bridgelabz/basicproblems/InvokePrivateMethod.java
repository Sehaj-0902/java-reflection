package com.bridgelabz.basicproblems;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Class<?> cls = calculator.getClass();

        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(calculator, 2, 4);
        System.out.println("Multiplication Result: " + result);
    }
}

/*
Output:
    Multiplication Result: 8
 */