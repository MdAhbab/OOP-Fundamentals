package com.example.javaguide.methods;

/**
 * ParametersDemo - Additional parameter passing examples.
 * 
 * In Java, parameters are ALWAYS pass-by-value.
 * - For primitives, the actual value is copied.
 * - For objects, the reference to the object is copied (so the method
 *   modifies the same underlying object).
 */
public class ParametersDemo {
    
    /**
     * Main method running parameter demonstrations.
     */
    public static void main(String[] args) {
        demonstrateObjectParameters();
    }
    
    /**
     * Demonstrates how passing an object allows the method to mutate 
     * its internal state because the reference is copied.
     */
    public static void demonstrateObjectParameters() {
        System.out.println("=== Object Parameters ===");
        
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Before: " + sb);
        
        modifyStringBuilder(sb);
        System.out.println("After: " + sb); // Modified!
        
        // This works because reference is copied, but points to same object
    }
    
    /**
     * Helper method to modify a StringBuilder instance.
     * 
     * @param builder The StringBuilder object reference to modify
     */
    public static void modifyStringBuilder(StringBuilder builder) {
        builder.append(" World");
    }
    
    /**
     * Swaps two integers (won't work due to pass-by-value).
     * Modifies the local copies of the integers, leaving originals untouched.
     * 
     * @param a First integer (copy)
     * @param b Second integer (copy)
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        // Changes are local only
    }
    
    /**
     * Calculates average of an arbitrary number of numbers using varargs.
     * 
     * @param numbers Varargs Array of numbers
     * @return The double average of the numbers, or 0 if empty
     */
    public static double average(int... numbers) {
        if (numbers.length == 0) return 0;
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}
