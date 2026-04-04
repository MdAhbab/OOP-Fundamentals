package com.example.javaguide.controlflow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ControlFlowTest {
    
    @Test
    @DisplayName("Grade calculation should work correctly")
    void testGetGrade() {
        assertEquals("A", ControlFlowDemo.getGrade(95));
        assertEquals("B", ControlFlowDemo.getGrade(85));
        assertEquals("C", ControlFlowDemo.getGrade(75));
        assertEquals("D", ControlFlowDemo.getGrade(65));
        assertEquals("F", ControlFlowDemo.getGrade(55));
    }
    
    @Test
    @DisplayName("Even number check should work")
    void testIsEven() {
        assertTrue(ControlFlowDemo.isEven(4));
        assertFalse(ControlFlowDemo.isEven(5));
        assertTrue(ControlFlowDemo.isEven(0));
        assertTrue(ControlFlowDemo.isEven(-2));
    }
    
    @Test
    @DisplayName("Factorial calculation should be correct")
    void testFactorial() {
        assertEquals(1, ControlFlowDemo.factorial(0));
        assertEquals(1, ControlFlowDemo.factorial(1));
        assertEquals(2, ControlFlowDemo.factorial(2));
        assertEquals(6, ControlFlowDemo.factorial(3));
        assertEquals(24, ControlFlowDemo.factorial(4));
        assertEquals(120, ControlFlowDemo.factorial(5));
    }
    
    @Test
    @DisplayName("Sum of numbers should be correct")
    void testSumOfNumbers() {
        assertEquals(0, LoopsDemo.sumOfNumbers(0));
        assertEquals(1, LoopsDemo.sumOfNumbers(1));
        assertEquals(15, LoopsDemo.sumOfNumbers(5));  // 1+2+3+4+5
        assertEquals(55, LoopsDemo.sumOfNumbers(10)); // Sum of 1 to 10
    }
}
