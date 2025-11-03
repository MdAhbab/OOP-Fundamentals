package com.example.javaguide.controlflow;

/**
 * LoopsDemo - Additional loop examples and patterns
 */
public class LoopsDemo {
    
    public static void main(String[] args) {
        printPattern();
        printMultiplicationTable(5);
    }
    
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
    
    public static void printMultiplicationTable(int number) {
        System.out.println("=== Multiplication Table for " + number + " ===");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        System.out.println();
    }
    
    public static int sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
