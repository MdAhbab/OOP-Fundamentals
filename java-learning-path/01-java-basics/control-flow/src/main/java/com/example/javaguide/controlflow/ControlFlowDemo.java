package com.example.javaguide.controlflow;

/**
 * ControlFlowDemo - Demonstrates conditional statements and loops in Java.
 *
 * Control flow determines the order in which statements are executed.
 * This class covers:
 * - if/else and nested if-else statements
 * - switch statements (using the enhanced switch expression)
 * - for loops, while loops, and do-while loops
 * - break and continue statements
 */
public class ControlFlowDemo {
    
    /**
     * Main method running all control flow demonstrations.
     */
    public static void main(String[] args) {
        demonstrateIfElse();
        demonstrateSwitch();
        demonstrateForLoop();
        demonstrateWhileLoop();
        demonstrateDoWhileLoop();
        demonstrateBreakContinue();
    }
    
    /**
     * Demonstrates the basic if-else and if-else-if ladder.
     */
    public static void demonstrateIfElse() {
        System.out.println("=== If-Else Statements ===");
        
        int age = 18;
        if (age >= 18) {
            System.out.println(age + " is an adult");
        } else {
            System.out.println(age + " is a minor");
        }
        
        // Nested if-else
        int score = 85;
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Score " + score + " = Grade " + grade);
        System.out.println();
    }
    /**
     * Demonstrates the enhanced switch expression (introduced in Java 14).
     * It uses the arrow syntax (->) and yields a value directly without needing 'break'.
     */
    public static void demonstrateSwitch() {
        System.out.println("=== Switch Statement ===");
        
        int day = 1;
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };
        System.out.println("Day " + day + " is " + dayName);
        System.out.println();
    }
    /**
     * Demonstrates standard for loops and enhanced for loops (for-each).
     * Used when the number of iterations is known before entering the loop.
     */
    public static void demonstrateForLoop() {
        System.out.println("=== For Loop ===");
        
        System.out.print("Count: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + (i < 4 ? ", " : "\n"));
        }
        
        // Enhanced for loop
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.print("Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
    /**
     * Demonstrates the while loop.
     * Used when the condition needs to be checked before loop execution.
     */
    public static void demonstrateWhileLoop() {
        System.out.println("=== While Loop ===");
        
        int count = 5;
        System.out.print("Countdown: ");
        while (count > 0) {
            System.out.print(count + (count > 1 ? ", " : "\n"));
            count--;
        }
        System.out.println();
    }
    /**
     * Demonstrates the do-while loop.
     * Guaranteed to execute at least once, as the condition is checked after the block.
     */
    public static void demonstrateDoWhileLoop() {
        System.out.println("=== Do-While Loop ===");
        
        int i = 1;
        System.out.print("Numbers: ");
        do {
            System.out.print(i + (i < 5 ? ", " : "\n"));
            i++;
        } while (i <= 5);
        System.out.println();
    }
    /**
     * Demonstrates the use of 'break' (exiting a loop entirely) and
     * 'continue' (skipping the current iteration and moving to the next).
     */
    public static void demonstrateBreakContinue() {
        System.out.println("=== Break and Continue ===");
        
        // Break example
        System.out.print("Break at 5: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Continue example
        System.out.print("Skip even numbers: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
    /**
     * Utility method: Translates a numerical score into a letter grade.
     * 
     * @param score The numerical score (0-100)
     * @return The corresponding letter grade
     */
    public static String getGrade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
    /**
     * Utility method: Checks if a given number is even.
     * 
     * @param number The number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    /**
     * Utility method: Calculates the factorial of a given number.
     * 
     * @param n The input number
     * @return The calculated factorial of n
     */
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
