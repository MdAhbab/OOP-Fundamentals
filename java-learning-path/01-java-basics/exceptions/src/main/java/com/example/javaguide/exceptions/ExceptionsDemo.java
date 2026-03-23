package com.example.javaguide.exceptions;

import java.io.*;

/**
 * ExceptionsDemo - Demonstrates exception handling strategies and concepts in Java.
 * 
 * This class covers:
 * - Fundamental try-catch mechanics
 * - The 'finally' block
 * - Multiple catches / Multi-catch syntax
 * - 'throws' declarations on method signatures
 * - Custom structured exceptions
 * - The try-with-resources statement
 */
public class ExceptionsDemo {
    
    /**
     * Main method running series of exception demonstrations.
     */
    public static void main(String[] args) {
        demonstrateTryCatch();
        demonstrateFinally();
        demonstrateMultipleCatch();
        demonstrateThrows();
        demonstrateCustomException();
        demonstrateTryWithResources();
    }
    /**
     * Demonstrates a standard try-catch block wrapping arithmetic operations.
     */
    public static void demonstrateTryCatch() {
        System.out.println("=== Try-Catch Demo ===");
        
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println("Program continues after exception\n");
    }
    /**
     * Demonstrates the 'finally' block, illustrating that it will always execute
     * regardless of whether an exception occurs.
     */
    public static void demonstrateFinally() {
        System.out.println("=== Finally Block ===");
        
        try {
            System.out.println("In try block");
            int[] arr = new int[5];
            arr[10] = 50; // Will throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Finally block always executes");
        }
        
        System.out.println();
    }
    /**
     * Demonstrates handling varying types of exceptions with sequential catch blocks 
     * and the Java 7+ multi-catch capability.
     */
    public static void demonstrateMultipleCatch() {
        System.out.println("=== Multiple Catch Blocks ===");
        
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception handled");
        } catch (Exception e) {
            System.out.println("General exception handled");
        }
        
        // Multi-catch (Java 7+)
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Number or null exception: " + e.getClass().getSimpleName());
        }
        
        System.out.println();
    }
    /**
     * Demonstrates how methods throwing checked exceptions force calling methods 
     * to manage them via a localized try-catch or a throws declaration.
     */
    public static void demonstrateThrows() {
        System.out.println("=== Throws Declaration ===");
        
        try {
            riskyMethod();
        } catch (IOException e) {
            System.out.println("Handled IOException: " + e.getMessage());
        }
        
        System.out.println();
    }
    /**
     * Demonstrates utilizing a user-defined custom exception derived from the Exception class.
     */
    public static void demonstrateCustomException() {
        System.out.println("=== Custom Exception ===");
        
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        }
        
        try {
            validateAge(25);
            System.out.println("Age 25 is valid");
        } catch (InvalidAgeException e) {
            System.out.println("This won't execute");
        }
        
        System.out.println();
    }
    /**
     * Demonstrates the try-with-resources feature (Java 7+) which automatically closes
     * objects implementing the AutoCloseable interface to prevent resource leaks.
     */
    public static void demonstrateTryWithResources() {
        System.out.println("=== Try-With-Resources ===");
        
        // Auto-closes resources
        try (StringWriter writer = new StringWriter()) {
            writer.write("Hello, World!");
            System.out.println("Written: " + writer.toString());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
        // writer is automatically closed here
        
        System.out.println();
    }
    
    // Helper methods
    
    /**
     * Simple division utility throwing a runtime exception if the denominator is zero.
     * 
     * @param a The numerator
     * @param b The denominator
     * @return The integer division result
     */
    public static int divide(int a, int b) {
        return a / b; // Throws ArithmeticException if b is 0
    }
    /**
     * An example method deliberately firing a checked IOException to illustrate
     * the 'throws' syntax requirement.
     * 
     * @throws IOException Always thrown internally
     */
    public static void riskyMethod() throws IOException {
        // Method declares that it might throw IOException
        throw new IOException("Simulated IO error");
    }
    /**
     * Validator ensuring an age constraint, triggering our customized checked exception on failure.
     * 
     * @param age Integer age passed for validation
     * @throws InvalidAgeException if the age falls beneath constraints
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older");
        }
    }
    /**
     * Attempts reading the first line of a file, using try-with-resources
     * and returning standard string responses dynamically on fault variants.
     * 
     * @param filename Targeted file string name
     * @return A retrieved string component or an error narrative
     */
    public static String readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            return "File not found: " + filename;
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
    /**
     * Utility parser protecting core program execution flow by swallowing failures 
     * dynamically inside standard conversions.
     * 
     * @param str Candidate parse string
     * @return Processed parse target result, or null upon failure
     */
    public static Integer parseIntSafely(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
