package com.example.javaguide.arrays;

import java.util.Arrays;

/**
 * MultiDimensionalArraysDemo - Demonstrates 2D and 3D arrays
 */
public class MultiDimensionalArraysDemo {
    
    public static void main(String[] args) {
        demonstrate2DArrays();
        demonstrateJaggedArrays();
    }
    
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
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }
    
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
