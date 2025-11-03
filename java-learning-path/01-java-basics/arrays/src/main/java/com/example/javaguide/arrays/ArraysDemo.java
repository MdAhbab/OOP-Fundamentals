package com.example.javaguide.arrays;

import java.util.Arrays;

/**
 * ArraysDemo - Demonstrates array declaration, initialization, and operations
 */
public class ArraysDemo {
    
    public static void main(String[] args) {
        demonstrateBasics();
        demonstrateOperations();
        demonstrateArraysClass();
        demonstrateEnhancedForLoop();
    }
    
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
    
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
    
    public static double average(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) sum(arr) / arr.length;
    }
    
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
    
    public static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    public static boolean contains(int[] arr, int value) {
        return linearSearch(arr, value) != -1;
    }
}
