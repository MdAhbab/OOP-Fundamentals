package com.example.javaguide.arrays;

import java.util.Arrays;

/**
 * ArraysDemo - Demonstrates array declaration, initialization, and operations in Java.
 * 
 * An array is a container object that holds a fixed number of values of a single type.
 * This class covers:
 * - Basic array declaration and allocation
 * - Array operations (sum, average, min, max, reverse)
 * - The java.util.Arrays utility class
 * - Enhanced for-loop iteration
 */
public class ArraysDemo {
    
    /**
     * Main method running array demonstrations.
     */
    public static void main(String[] args) {
        demonstrateBasics();
        demonstrateOperations();
        demonstrateArraysClass();
        demonstrateEnhancedForLoop();
    }
    
    /**
     * Demonstrates basic array creation, indexing, and array literals.
     */
    public static void demonstrateBasics() {
        System.out.println("=== Array Basics ===");
        
        // Declaration and initialization
        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        System.out.println("Array length: " + numbers.length);
        System.out.println("Element at index 0: " + numbers[0]);
        
        // Array literal
        int[] scores = {95, 87, 92, 78, 88};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println();
    }
    
    /**
     * Demonstrates common array algorithms (sum, average, max, min, reversal).
     */
    public static void demonstrateOperations() {
        System.out.println("=== Array Operations ===");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Sum
        int sum = sum(numbers);
                System.out.println("Sum: " + sum);
        
        // Average
        double avg = average(numbers);
        System.out.println("Average: " + avg);
        
        // Max and Min
        System.out.println("Max: " + max(numbers));
        System.out.println("Min: " + min(numbers));
        
        // Reverse
        int[] reversed = reverse(numbers);
        System.out.println("Reversed: " + Arrays.toString(reversed));
        System.out.println();
    }
    
    /**
     * Demonstrates the built-in java.util.Arrays utility methods 
     * like sort(), binarySearch(), fill(), and copyOf().
     */
    public static void demonstrateArraysClass() {
        System.out.println("=== Arrays Utility Class ===");
        
        int[] numbers = {5, 2, 8, 1, 9};
        System.out.println("Original: " + Arrays.toString(numbers));
        
        // Sort
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));
        
        // Binary search (only on sorted arrays)
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);
        
        // Fill
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled with 7: " + Arrays.toString(filled));
        
        // Copy
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy: " + Arrays.toString(copy));
        System.out.println();
    }
    
    /**
     * Demonstrates how to iterate through an array using the enhanced for-loop.
     */
    public static void demonstrateEnhancedForLoop() {
        System.out.println("=== Enhanced For Loop ===");
        
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        
        System.out.print("Fruits: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");
    }
    
    // Utility methods
    
    /**
     * Calculates the sum of all elements in an integer array.
     * 
     * @param arr The input array
     * @return The sum of all elements
     */
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
    
    /**
     * Calculates the average of all elements in an integer array.
     * 
     * @param arr The input array
     * @return The double average, or 0 if array is empty
     */
    public static double average(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) sum(arr) / arr.length;
    }
    
    /**
     * Finds the maximum value in an integer array.
     * 
     * @param arr The input array
     * @return The maximum element in the array
     * @throws IllegalArgumentException if the array is empty
     */
    public static int max(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }
    
    /**
     * Finds the minimum value in an integer array.
     * 
     * @param arr The input array
     * @return The minimum element in the array
     * @throws IllegalArgumentException if the array is empty
     */
    public static int min(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }
    
    /**
     * Returns a new array with the elements of the input array in reverse order.
     * 
     * @param arr The input array
     * @return A newly allocated array with reversed elements
     */
    public static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    
    /**
     * Performs a linear search to find the index of a target value.
     * 
     * @param arr The array to search
     * @param target The value to search for
     * @return The index of the target, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    /**
     * Checks if an array contains a specific value using linear search.
     * 
     * @param arr The input array
     * @param value The value to check for 
     * @return true if the value exists in the array
     */
    public static boolean contains(int[] arr, int value) {
        return linearSearch(arr, value) != -1;
    }
}
