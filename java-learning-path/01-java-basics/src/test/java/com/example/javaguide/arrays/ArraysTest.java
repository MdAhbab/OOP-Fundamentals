package com.example.javaguide.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    
    @Test
    @DisplayName("Sum should calculate correctly")
    void testSum() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(15, ArraysDemo.sum(arr));
        assertEquals(0, ArraysDemo.sum(new int[]{}));
    }
    
    @Test
    @DisplayName("Average should calculate correctly")
    void testAverage() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(30.0, ArraysDemo.average(arr), 0.001);
        assertEquals(0.0, ArraysDemo.average(new int[]{}));
    }
    
    @Test
    @DisplayName("Max should find maximum value")
    void testMax() {
        int[] arr = {5, 2, 9, 1, 7};
        assertEquals(9, ArraysDemo.max(arr));
        
        assertThrows(IllegalArgumentException.class, () -> {
            ArraysDemo.max(new int[]{});
        });
    }
    
    @Test
    @DisplayName("Min should find minimum value")
    void testMin() {
        int[] arr = {5, 2, 9, 1, 7};
        assertEquals(1, ArraysDemo.min(arr));
        
        assertThrows(IllegalArgumentException.class, () -> {
            ArraysDemo.min(new int[]{});
        });
    }
    
    @Test
    @DisplayName("Reverse should reverse array")
    void testReverse() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, ArraysDemo.reverse(arr));
    }
    
    @Test
    @DisplayName("Linear search should find element")
    void testLinearSearch() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(2, ArraysDemo.linearSearch(arr, 30));
        assertEquals(-1, ArraysDemo.linearSearch(arr, 99));
    }
    
    @Test
    @DisplayName("Contains should check if element exists")
    void testContains() {
        int[] arr = {10, 20, 30, 40, 50};
        assertTrue(ArraysDemo.contains(arr, 30));
        assertFalse(ArraysDemo.contains(arr, 99));
    }
    
    @Test
    @DisplayName("Matrix sum should calculate correctly")
    void testSumMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertEquals(45, MultiDimensionalArraysDemo.sumMatrix(matrix));
    }
    
    @Test
    @DisplayName("Matrix transpose should work correctly")
    void testTransposeMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] expected = {
            {1, 4},
            {2, 5},
            {3, 6}
        };
        assertArrayEquals(expected, MultiDimensionalArraysDemo.transposeMatrix(matrix));
    }
}
