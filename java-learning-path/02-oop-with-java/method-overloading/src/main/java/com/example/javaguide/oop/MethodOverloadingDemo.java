package com.example.javaguide.oop;

import java.util.Arrays;

/**
 * MethodOverloadingDemo - Demonstrates method overloading in Java
 */
public class MethodOverloadingDemo {
    
    public static void main(String[] args) {
        demonstrateBasicOverloading();
        demonstrateConstructorOverloading();
        demonstrateVarargsOverloading();
        demonstrateTypePromotion();
    }
    
    public static void demonstrateBasicOverloading() {
        System.out.println("=== Basic Method Overloading ===");
        
        Calculator calc = new Calculator();
        
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("add(\"Hello\", \"World\") = " + calc.add("Hello", "World"));
        System.out.println();
    }
    
    public static void demonstrateConstructorOverloading() {
        System.out.println("=== Constructor Overloading ===");
        
        Person p1 = new Person();
        Person p2 = new Person("Alice");
        Person p3 = new Person("Bob", 30);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println();
    }
    
    public static void demonstrateVarargsOverloading() {
        System.out.println("=== Varargs Overloading ===");
        
        Printer printer = new Printer();
        
        printer.print(42);
        printer.print("Hello");
        printer.print(1, 2, 3, 4, 5);
        printer.print("A", "B", "C");
        System.out.println();
    }
    
    public static void demonstrateTypePromotion() {
        System.out.println("=== Type Promotion ===");
        
        TypePromotionDemo demo = new TypePromotionDemo();
        
        byte b = 10;
        short s = 20;
        char c = 'A';
        
        demo.process(b);    // byte → int
        demo.process(s);    // short → int
        demo.process(c);    // char → int
        demo.process(100);  // int
        demo.process(3.14); // double
        System.out.println();
    }
}

// Basic method overloading
class Calculator {
    // Overloaded by parameter type
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    // Overloaded by number of parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Overloaded by parameter order
    public String add(String a, String b) {
        return a + " " + b;
    }
    
    // Cannot do this - return type alone is not sufficient
    // public double add(int a, int b) { } // Compile error
}

// Constructor overloading
class Person {
    private String name;
    private int age;
    
    // Default constructor
    public Person() {
        this("Unknown", 0);
    }
    
    // Constructor with name
    public Person(String name) {
        this(name, 0);
    }
    
    // Constructor with name and age
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Varargs overloading
class Printer {
    // Specific type overloads
    public void print(int value) {
        System.out.println("Integer: " + value);
    }
    
    public void print(String value) {
        System.out.println("String: " + value);
    }
    
    // Varargs for integers
    public void print(int... numbers) {
        System.out.println("Integer array: " + Arrays.toString(numbers));
    }
    
    // Varargs for strings
    public void print(String... strings) {
        System.out.println("String array: " + Arrays.toString(strings));
    }
    
    // Note: Ambiguous call would occur if you call print() with no args
    // when having multiple varargs methods
}

// Type promotion
class TypePromotionDemo {
    public void process(int value) {
        System.out.println("Processing int: " + value);
    }
    
    public void process(double value) {
        System.out.println("Processing double: " + value);
    }
    
    public void process(long value) {
        System.out.println("Processing long: " + value);
    }
}

// Distance calculation with different parameter types
class DistanceCalculator {
    // 2D distance
    public double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
    
    // 3D distance
    public double distance(int x, int y, int z) {
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    // Distance with doubles for precision
    public double distance(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
    
    // Distance between two points
    public double distance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Display method overloading
class Display {
    public void show(int value) {
        System.out.println("Integer: " + value);
    }
    
    public void show(String value) {
        System.out.println("String: " + value);
    }
    
    public void show(boolean value) {
        System.out.println("Boolean: " + value);
    }
    
    public void show(int[] values) {
        System.out.println("Array: " + Arrays.toString(values));
    }
}
