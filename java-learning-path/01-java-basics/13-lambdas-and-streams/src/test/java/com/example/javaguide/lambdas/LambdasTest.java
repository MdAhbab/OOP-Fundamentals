package com.example.javaguide.lambdas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class LambdasTest {
    
    @Test
    @DisplayName("Filter even numbers should work")
    void testFilterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = LambdasDemo.filterEvenNumbers(numbers);
        
        assertEquals(3, evens.size());
        assertTrue(evens.contains(2));
        assertTrue(evens.contains(4));
        assertTrue(evens.contains(6));
    }
    
    @Test
    @DisplayName("Convert to uppercase should work")
    void testConvertToUpperCase() {
        List<String> words = Arrays.asList("hello", "world");
        List<String> upper = LambdasDemo.convertToUpperCase(words);
        
        assertEquals("HELLO", upper.get(0));
        assertEquals("WORLD", upper.get(1));
    }
    
    @Test
    @DisplayName("Find max should return maximum")
    void testFindMax() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        Optional<Integer> max = LambdasDemo.findMax(numbers);
        
        assertTrue(max.isPresent());
        assertEquals(9, max.get());
    }
    
    @Test
    @DisplayName("Calculate average should work")
    void testCalculateAverage() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        double avg = LambdasDemo.calculateAverage(numbers);
        
        assertEquals(6.0, avg);
    }
}
