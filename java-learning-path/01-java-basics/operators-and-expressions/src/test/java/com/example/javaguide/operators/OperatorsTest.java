package com.example.javaguide.operators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {
    
    @Test
    @DisplayName("Arithmetic operators should work correctly")
    void testArithmeticOperators() {
        assertEquals(15, OperatorsDemo.add(10, 5));
        assertEquals(5, OperatorsDemo.subtract(10, 5));
        assertEquals(50, OperatorsDemo.multiply(10, 5));
        assertEquals(2, OperatorsDemo.divide(10, 5));
        assertEquals(1, OperatorsDemo.modulus(10, 3));
    }
    
    @Test
    @DisplayName("Division by zero should throw exception")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            OperatorsDemo.divide(10, 0);
        });
    }
    
    @Test
    @DisplayName("Operator precedence should be correct")
    void testOperatorPrecedence() {
        assertEquals(14, 2 + 3 * 4);  // Not 20
        assertEquals(20, (2 + 3) * 4);
    }
    
    @Test
    @DisplayName("Relational operators should work correctly")
    void testRelationalOperators() {
        assertTrue(10 > 5);
        assertFalse(10 < 5);
        assertTrue(10 >= 10);
        assertTrue(10 <= 10);
        assertTrue(10 == 10);
        assertTrue(10 != 5);
    }
    
    @Test
    @DisplayName("Logical operators should work correctly")
    void testLogicalOperators() {
        assertTrue(true && true);
        assertFalse(true && false);
        assertTrue(true || false);
        assertFalse(false || false);
        assertTrue(!false);
        assertFalse(!true);
    }
    
    @Test
    @DisplayName("Bitwise operators should work correctly")
    void testBitwiseOperators() {
        assertEquals(1, 5 & 3);   // 0101 & 0011 = 0001
        assertEquals(7, 5 | 3);   // 0101 | 0011 = 0111
        assertEquals(6, 5 ^ 3);   // 0101 ^ 0011 = 0110
        assertEquals(10, 5 << 1); // Left shift
        assertEquals(2, 5 >> 1);  // Right shift
    }
    
    @Test
    @DisplayName("Ternary operator should work correctly")
    void testTernaryOperator() {
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        assertEquals(20, max);
        
        String parity = (a % 2 == 0) ? "even" : "odd";
        assertEquals("even", parity);
    }
}
