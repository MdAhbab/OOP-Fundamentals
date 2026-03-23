package com.example.javaguide.methods;

/**
 * MethodsDemo - Demonstrates method declaration, parameters, and usage in Java.
 * 
 * A method is a block of code which only runs when it is called.
 * This class covers:
 * - Method syntax (return types, void methods)
 * - Method overloading
 * - Variable arguments (varargs)
 * - Recursion
 * - Pass-by-value semantics
 */
public class MethodsDemo {
    
    /**
     * Main method running all methods demonstrations.
     */
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
     * Adds two integers.
     * 
     * @param a The first integer to add
     * @param b The second integer to add
     * @return The sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Multiplies two integers.
     * 
     * @param a The first integer
     * @param b The second integer
     * @return The product of a and b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Void method - returns nothing, simply prints a greeting.
     * 
     * @param name The name of the person/entity to greet
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
    
    /**
     * Overloaded method: Adds two doubles.
     * 
     * @param a First double
     * @param b Second double
     * @return The sum of a and b as a double
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Overloaded method: Adds three integers.
     * 
     * @param a First integer
     * @param b Second integer
     * @param c Third integer
     * @return The sum of a, b, and c
     */
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
    
    /**
     * Varargs method: sums any number of integer parameters.
     * Internal implementation treats 'numbers' as an array.
     * 
     * @param numbers The varargs array of integers to sum
     * @return The total sum 
     */
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    /**
     * Varargs method: prints any number of string parameters.
     * 
     * @param items The varargs array of strings to print
     */
    public static void printAll(String... items) {
        System.out.print("Items: ");
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates recursion by calling factorial and fibonacci methods.
     */
    public static void demonstrateRecursion() {
        System.out.println("=== Recursion ===");
        
        int n = 5;
        System.out.println("Factorial of " + n + " = " + factorial(n));
        System.out.println("Fibonacci(7) = " + fibonacci(7));
        System.out.println();
    }
    
    /**
     * Recursive method: computes the factorial of n (n!).
     * 
     * @param n The input number
     * @return The factorial
     */
    public static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    /**
     * Recursive method: computes the nth Fibonacci number.
     * 
     * @param n The sequence index
     * @return The Fibonacci number at index n
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Demonstrates that Java primitives are pass-by-value.
     */
    public static void demonstratePassByValue() {
        System.out.println("=== Pass By Value ===");
        
        int x = 10;
        System.out.println("Before: x = " + x);
        tryToModify(x);
        System.out.println("After: x = " + x); // Still 10
        System.out.println();
    }
    
    /**
     * Helper method to show that modifying a primitive parameter 
     * does not affect the original variable.
     * 
     * @param value A copy of the primitive value
     */
    public static void tryToModify(int value) {
        value = 99; // Only modifies the copy
        System.out.println("Inside method: value = " + value);
    }
    
    /**
     * Calculates power using recursion.
     * 
     * @param base The base number
     * @param exponent The exponent to raise the base to
     * @return The calculated power
     */
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    
    /**
     * Finds the maximum of two numbers.
     * 
     * @param a First number
     * @param b Second number
     * @return The greater of a or b
     */
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    /**
     * Finds the minimum of two numbers.
     * 
     * @param a First number
     * @param b Second number
     * @return The smaller of a or b
     */
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
