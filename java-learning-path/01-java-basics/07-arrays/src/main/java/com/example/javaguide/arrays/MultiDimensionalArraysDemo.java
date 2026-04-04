package com.example.javaguide.arrays;

import java.util.Arrays;

/**
 * MultiDimensionalArraysDemo - Demonstrates 2D and jagged arrays in Java.
 * 
 * Multidimensional arrays are arrays of arrays.
 * This class covers:
 * - 2D matrix declaration and initialization
 * - Jagged arrays (arrays where rows have varying lengths)
 * - Matrix traversal and mathematical operations
 */
public class MultiDimensionalArraysDemo {
    
    /**
     * Main method running demonstrations of multidimensional arrays.
     */
    public static void main(String[] args) {
        demonstrate2DArrays();
        demonstrateJaggedArrays();
    }
    
    /**
     * Demonstrates standard 2D arrays (matrices) with equal length rows.
     */
    public static void demonstrate2DArrays() {
        System.out.println("=== 2D Arrays ===");
        
        // Matrix declaration
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        printMatrix(matrix);
        
        // Sum of all elements
        int sum = sumMatrix(matrix);
        System.out.println("Sum of all elements: " + sum);
        System.out.println();
    }
    
    /**
     * Demonstrates jagged arrays, where each sub-array can have a different length.
     */
    public static void demonstrateJaggedArrays() {
        System.out.println("=== Jagged Arrays ===");
        
        // Arrays with different lengths
        int[][] jagged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        
        System.out.println("Jagged array:");
        for (int i = 0; i < jagged.length; i++) {
            System.out.println("Row " + i + ": " + Arrays.toString(jagged[i]));
        }
        System.out.println();
    }
    
    /**
     * Utility method: iterates through a matrix to print its layout.
     * 
     * @param matrix The 2D array to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Utility method: calculates the sum of all elements within a 2D matrix.
     * 
     * @param matrix The 2D array to sum over
     * @return Target sum 
     */
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }
    
    /**
     * Utility method: transposes a matrix (flips it over its diagonal, 
     * shifting rows to columns and columns to rows).
     * 
     * @param matrix The original 2D matrix
     * @return The new transposed 2D matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
