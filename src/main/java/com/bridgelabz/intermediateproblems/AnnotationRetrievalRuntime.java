package com.bridgelabz.intermediateproblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name();
}

class AnnotationTest {
    @Author(name = "Author Name")
    public void displayName() {
        System.out.println("Author Name: Sehaj");
    }
}

public class AnnotationRetrievalRuntime {
    public static void main(String[] args) throws Exception {
        AnnotationTest obj = new AnnotationTest();
        Class<?> cls = obj.getClass();

        Method method = cls.getMethod("displayName");

        if (method.isAnnotationPresent(Author.class)) {
            Author author = method.getAnnotation(Author.class);
            System.out.println("Annotation Value: " + author.name());
        }

        method.invoke(obj);
    }
}

/*
Output:
    Annotation Value: Author Name
    Author Name: Sehaj
 */