package com.example.javaguide.generics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class GenericsTest {
    
    @Test
    @DisplayName("Box should store and retrieve values")
    void testBox() {
        Box<String> box = new Box<>();
        box.set("Test");
        
        assertEquals("Test", box.get());
        assertFalse(box.isEmpty());
    }
    
    @Test
    @DisplayName("Pair should store key-value pairs")
    void testPair() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        
        assertEquals("Age", pair.getKey());
        assertEquals(30, pair.getValue());
    }
    
    @Test
    @DisplayName("findMax should find maximum element")
    void testFindMax() {
        Integer[] numbers = {5, 2, 8, 1, 9};
        Integer max = GenericsDemo.findMax(numbers);
        
        assertEquals(9, max);
        
        String[] words = {"apple", "zebra", "banana"};
        String maxWord = GenericsDemo.findMax(words);
        
        assertEquals("zebra", maxWord);
    }
    
    @Test
    @DisplayName("sumOfList should sum numbers")
    void testSumOfList() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        double sum = GenericsDemo.sumOfList(integers);
        
        assertEquals(15.0, sum);
        
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.0);
        double doubleSum = GenericsDemo.sumOfList(doubles);
        
        assertEquals(7.0, doubleSum);
    }
    
    @Test
    @DisplayName("GenericStack should work like a stack")
    void testGenericStack() {
        GenericStack<Integer> stack = new GenericStack<>();
        
        assertTrue(stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals(3, stack.size());
        assertEquals(30, stack.peek());
        assertEquals(30, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }
    
    @Test
    @DisplayName("GenericStack should throw exception when empty")
    void testGenericStackEmpty() {
        GenericStack<String> stack = new GenericStack<>();
        
        assertThrows(EmptyStackException.class, stack::pop);
        assertThrows(EmptyStackException.class, stack::peek);
    }
    
    @Test
    @DisplayName("sumOfNumbers should work with bounded types")
    void testSumOfNumbers() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        double sum = GenericsDemo.sumOfNumbers(integers);
        
        assertEquals(6.0, sum);
    }
}
