package com.example.javaguide.strings;

/**
 * StringBuilderDemo - Demonstrates StringBuilder utility for immutable strings in Java.
 * 
 * StringBuilder and StringBuffer are mutable sequences of characters.
 * StringBuilder is generally preferred as it is faster (but not thread-safe).
 * This class covers:
 * - Common operations (append, insert, replace, delete, reverse)
 * - Performance comparison against String concatenation
 */
public class StringBuilderDemo {
    
    /**
     * Main method running StringBuilder demonstrations.
     */
    public static void main(String[] args) {
        demonstrateStringBuilder();
        demonstratePerformance();
    }
    
    /**
     * Demonstrates the primary methods inside StringBuilder.
     */
    public static void demonstrateStringBuilder() {
        System.out.println("=== StringBuilder Demo ===");
        
        StringBuilder sb = new StringBuilder("Hello");
        
        // Append
        sb.append(" World");
        System.out.println("After append: " + sb);
        
        // Insert
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);
        
        // Replace
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
        
        // Delete
        sb.delete(2, 4);
        System.out.println("After delete: " + sb);
        
        // Reverse
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // Convert to String
        String result = sb.toString();
        System.out.println("Final string: " + result);
        System.out.println();
    }
    
    /**
     * Analyzes performance differences between standard string concatenation
     * and using a mutable StringBuilder structure over 10K iterations.
     */
    public static void demonstratePerformance() {
        System.out.println("=== Performance Comparison ===");
        
        int iterations = 10000;
        
        // Using String concatenation (slow)
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < iterations; i++) {
            s += "a";  // Creates new object each time
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String concatenation: " + (end1 - start1) + "ms");
        
        // Using StringBuilder (fast)
        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");  // Modifies existing object
        }
        String result = sb.toString();
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end2 - start2) + "ms");
        System.out.println();
    }
    
    /**
     * Concatenates an arbitrary number of strings efficiently using StringBuilder.
     * 
     * @param strings Varargs sequence of strings to concatenate
     * @return A single concatenated string
     */
    public static String concatenateWithBuilder(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
