package com.example.javaguide.variables;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for data types and variables functionality
 */
class DataTypesTest {
    
    @Test
    @DisplayName("Constants should be accessible and unchangeable")
    void testConstants() {
        double pi = VariablesDemo.getPI();
        assertEquals(3.14159, pi, 0.00001);
    }
    
    @Test
    @DisplayName("Calculate sum with mixed types")
    void testCalculateSum() {
        int intValue = 10;
        double doubleValue = 5.5;
        
        double result = DataTypesDemo.calculateSum(intValue, doubleValue);
        
        assertEquals(15.5, result, 0.0001);
    }
    
    @Test
    @DisplayName("Type conversion should work correctly")
    void testTypeConversion() {
        // Implicit conversion
        int intVal = 100;
        double doubleVal = intVal;
        assertEquals(100.0, doubleVal, 0.0001);
        
        // Explicit conversion (truncation)
        double pi = 3.14159;
        int piInt = (int) pi;
        assertEquals(3, piInt);
    }
    
    @Test
    @DisplayName("Wrapper classes should box and unbox correctly")
    void testWrapperClasses() {
        // Autoboxing
        Integer wrapped = 42;
        assertNotNull(wrapped);
        assertEquals(42, wrapped);
        
        // Unboxing
        int unwrapped = wrapped;
        assertEquals(42, unwrapped);
    }
    
    @Test
    @DisplayName("Integer parsing should work")
    void testIntegerParsing() {
        String numberStr = "123";
        int parsed = Integer.parseInt(numberStr);
        assertEquals(123, parsed);
    }
    
    @Test
    @DisplayName("Byte overflow should wrap around")
    void testByteOverflow() {
        byte max = Byte.MAX_VALUE; // 127
        byte overflowed = (byte)(max + 1);
        assertEquals(Byte.MIN_VALUE, overflowed); // Wraps to -128
    }
    
    @Test
    @DisplayName("Character to int conversion")
    void testCharToIntConversion() {
        char letter = 'A';
        int asciiValue = letter;
        assertEquals(65, asciiValue);
    }
    
    @Test
    @DisplayName("Boolean values should be true or false")
    void testBooleanValues() {
        boolean trueValue = true;
        boolean falseValue = false;
        
        assertTrue(trueValue);
        assertFalse(falseValue);
        assertNotEquals(trueValue, falseValue);
    }
    
    @Test
    @DisplayName("Type limits should be correct")
    void testTypeLimits() {
        assertEquals(-128, Byte.MIN_VALUE);
        assertEquals(127, Byte.MAX_VALUE);
        assertEquals(-32768, Short.MIN_VALUE);
        assertEquals(32767, Short.MAX_VALUE);
    }
}
