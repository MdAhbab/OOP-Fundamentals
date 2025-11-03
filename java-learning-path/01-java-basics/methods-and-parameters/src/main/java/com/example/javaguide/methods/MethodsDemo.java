package com.example.javaguide.methods;

/**
 * MethodsDemo - Demonstrates method declaration, parameters, and usage
 */
public class MethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Method Basics ===");
        
        // Calling methods with parameters
        int sum = add(10, 5);
        System.out.println("Sum: " + sum);
        
        int product = multiply(10, 5);
        System.out.println("Product: " + product);
        
        // Void method (no return value)
        greet("Java Developer");
        
        demonstrateOverloading();
        demonstrateVarargs();
        demonstrateRecursion();
        demonstratePassByValue();
    }
    
    /**
     * Adds two integers
     */
    public static int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Multiplies two integers
     */
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Void method - returns nothing
     */
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
        System.out.println();
    }
    
    /**
     * Demonstrates method overloading
     */
    public static void demonstrateOverloading() {
        System.out.println("=== Method Overloading ===");
        
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("add(5.5, 3.2) = " + add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
        System.out.println();
    }
    
    // Overloaded methods
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    /**
     * Demonstrates variable arguments (varargs)
     */
    public static void demonstrateVarargs() {
        System.out.println("=== Variable Arguments ===");
        
        System.out.println("Sum of 1,2,3: " + sum(1, 2, 3));
        System.out.println("Sum of 1,2,3,4,5: " + sum(1, 2, 3, 4, 5));
        
        printAll("Java", "Python", "JavaScript", "C++");
        System.out.println();
    }
    
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    public static void printAll(String... items) {
        System.out.print("Items: ");
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates recursion
     */
    public static void demonstrateRecursion() {
        System.out.println("=== Recursion ===");
        
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
        System.out.println("Fibonacci(7) = " + fibonacci(7));
        System.out.println();
    }
    
    public static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Demonstrates pass-by-value behavior
     */
    public static void demonstratePassByValue() {
        System.out.println("=== Pass By Value ===");
        
        int x = 10;
        System.out.println("Before: x = " + x);
        tryToModify(x);
        System.out.println("After: x = " + x); // Still 10
        System.out.println();
    }
    
    public static void tryToModify(int value) {
        value = 99; // Only modifies the copy
        System.out.println("Inside method: value = " + value);
    }
    
    /**
     * Calculates power using recursion
     */
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    
    /**
     * Finds maximum of two numbers
     */
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    /**
     * Finds minimum of two numbers
     */
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
