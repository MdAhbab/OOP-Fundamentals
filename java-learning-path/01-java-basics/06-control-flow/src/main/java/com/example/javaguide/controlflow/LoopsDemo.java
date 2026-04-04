package com.example.javaguide.controlflow;

/**
 * LoopsDemo - Demonstrates practical examples and patterns using nested loops.
 * 
 * This class covers:
 * - Nested loops for 2D patterns
 * - Multiplication tables
 * - Accumulation/summation logic
 */
public class LoopsDemo {
    
    /**
     * Main method running practical loop examples.
     */
    public static void main(String[] args) {
        printPattern();
        printMultiplicationTable(5);
    }
    
    /**
     * Prints a triangular star pattern using nested for-loops.
     * The outer loop manages the rows, and the inner loop manages columns.
     */
    public static void printPattern() {
        System.out.println("=== Pattern Printing ===");
        
        // Triangle pattern
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Prints the multiplication table for a specific number.
     * 
     * @param number The number to generate the multiplication table for
     */
    public static void printMultiplicationTable(int number) {
        System.out.println("=== Multiplication Table for " + number + " ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        System.out.println();
    }
    /**
     * Calculates the sum of all numerical values from 1 up to n.
     * Demonstrates Accumulator pattern within a loop.
     * 
     * @param n The upper bound number
     * @return The accumulated sum of 1 to n
     */
    public static int sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
