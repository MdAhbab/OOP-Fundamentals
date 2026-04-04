package com.example.javaguide.packages.util;

/**
 * Helper - A utility class in a sub-package demonstrating package structure.
 * 
 * Provides simple utility methods that can be imported and executed.
 */
public class Helper {
    
    /**
     * Prints a formatted message to the standard output.
     * 
     * @param message The input string to print
     */
    public void printMessage(String message) {
        System.out.println("Helper says: " + message);
    }
    /**
     * Returns the sum of two integers.
     * 
     * @param a First integer
     * @param b Second integer
     * @return Sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }
    /**
     * Surrounds the input text with square brackets.
     * 
     * @param text The input string
     * @return Formatted string with brackets
     */
    public String format(String text) {
        return "[" + text + "]";
    }
}
