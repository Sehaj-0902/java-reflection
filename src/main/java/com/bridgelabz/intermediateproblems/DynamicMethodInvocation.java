package com.bridgelabz.intermediateproblems;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the math operation to be performed: \n(1 to Add, 2 to Subtract, 3 to Multiply)");
        int op = sc.nextInt();

        MathOperations mathOperation = new MathOperations();
        Class<?> cls = mathOperation.getClass();

        switch (op) {
            case 1:
                Method addMethod = cls.getDeclaredMethod("add", int.class, int.class);
                int addResult = (int) addMethod.invoke(mathOperation, 2, 4);
                System.out.println("Addition Result: " + addResult);
                break;
            case 2:
                Method subtractMethod = cls.getDeclaredMethod("subtract", int.class, int.class);
                int subtractResult = (int) subtractMethod.invoke(mathOperation, 7, 4);
                System.out.println("Subtraction Result: " + subtractResult);
                break;
            case 3:
                Method multiplyMethod = cls.getDeclaredMethod("multiply", int.class, int.class);
                int multiplyResult = (int) multiplyMethod.invoke(mathOperation, 3, 5);
                System.out.println("Multiplication Result: " + multiplyResult);
                break;
            default:
                throw new NoSuchMethodException();
        }
    }
}

/*
Input:
    Enter the math operation to be performed:
    (1 to Add, 2 to Subtract, 3 to Multiply)
    3
Output:
    Multiplication Result: 15
 */