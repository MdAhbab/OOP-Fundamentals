package com.example.javaguide.methods;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {
    
    @Test
    @DisplayName("Addition should work correctly")
    void testAdd() {
        assertEquals(15, MethodsDemo.add(10, 5));
        assertEquals(0, MethodsDemo.add(-5, 5));
        assertEquals(-10, MethodsDemo.add(-5, -5));
    }
    
    @Test
    @DisplayName("Multiplication should work correctly")
    void testMultiply() {
        assertEquals(50, MethodsDemo.multiply(10, 5));
        assertEquals(0, MethodsDemo.multiply(10, 0));
        assertEquals(-50, MethodsDemo.multiply(10, -5));
    }
    
    @Test
    @DisplayName("Overloaded add methods should work")
    void testOverloadedAdd() {
        assertEquals(8, MethodsDemo.add(5, 3));
        assertEquals(8.7, MethodsDemo.add(5.5, 3.2), 0.001);
        assertEquals(6, MethodsDemo.add(1, 2, 3));
    }
    
    @Test
    @DisplayName("Varargs sum should work")
    void testVarargsSum() {
        assertEquals(0, MethodsDemo.sum());
        assertEquals(5, MethodsDemo.sum(5));
        assertEquals(15, MethodsDemo.sum(1, 2, 3, 4, 5));
    }
    
    @Test
    @DisplayName("Factorial should calculate correctly")
    void testFactorial() {
        assertEquals(1, MethodsDemo.factorial(0));
        assertEquals(1, MethodsDemo.factorial(1));
        assertEquals(2, MethodsDemo.factorial(2));
        assertEquals(6, MethodsDemo.factorial(3));
        assertEquals(120, MethodsDemo.factorial(5));
    }
    
    @Test
    @DisplayName("Fibonacci should calculate correctly")
    void testFibonacci() {
        assertEquals(0, MethodsDemo.fibonacci(0));
        assertEquals(1, MethodsDemo.fibonacci(1));
        assertEquals(1, MethodsDemo.fibonacci(2));
        assertEquals(2, MethodsDemo.fibonacci(3));
        assertEquals(13, MethodsDemo.fibonacci(7));
    }
    
    @Test
    @DisplayName("Power calculation should work")
    void testPower() {
        assertEquals(1, MethodsDemo.power(5, 0));
        assertEquals(5, MethodsDemo.power(5, 1));
        assertEquals(25, MethodsDemo.power(5, 2));
        assertEquals(8, MethodsDemo.power(2, 3));
    }
    
    @Test
    @DisplayName("Max and min should work correctly")
    void testMaxMin() {
        assertEquals(10, MethodsDemo.max(10, 5));
        assertEquals(10, MethodsDemo.max(5, 10));
        assertEquals(5, MethodsDemo.min(10, 5));
        assertEquals(5, MethodsDemo.min(5, 10));
    }
    
    @Test
    @DisplayName("Average calculation should work")
    void testAverage() {
        assertEquals(0.0, ParametersDemo.average());
        assertEquals(5.0, ParametersDemo.average(5));
        assertEquals(3.0, ParametersDemo.average(1, 2, 3, 4, 5));
        assertEquals(7.5, ParametersDemo.average(5, 10));
    }
}
