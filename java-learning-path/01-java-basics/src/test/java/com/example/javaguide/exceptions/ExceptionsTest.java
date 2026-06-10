package com.example.javaguide.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class ExceptionsTest {
    
    @Test
    @DisplayName("Division by zero should throw ArithmeticException")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            ExceptionsDemo.divide(10, 0);
        });
    }
    
    @Test
    @DisplayName("Division should work normally")
    void testDivision() {
        assertEquals(5, ExceptionsDemo.divide(10, 2));
        assertEquals(2, ExceptionsDemo.divide(10, 5));
    }
    
    @Test
    @DisplayName("Risky method should throw IOException")
    void testRiskyMethod() {
        assertThrows(IOException.class, () -> {
            ExceptionsDemo.riskyMethod();
        });
    }
    
    @Test
    @DisplayName("Invalid age should throw custom exception")
    void testInvalidAge() {
        assertThrows(InvalidAgeException.class, () -> {
            ExceptionsDemo.validateAge(-5);
        });
        
        assertThrows(InvalidAgeException.class, () -> {
            ExceptionsDemo.validateAge(15);
        });
    }
    
    @Test
    @DisplayName("Valid age should not throw exception")
    void testValidAge() {
        assertDoesNotThrow(() -> {
            ExceptionsDemo.validateAge(25);
        });
        
        assertDoesNotThrow(() -> {
            ExceptionsDemo.validateAge(18);
        });
    }
    
    @Test
    @DisplayName("parseIntSafely should handle invalid input")
    void testParseIntSafely() {
        assertEquals(123, ExceptionsDemo.parseIntSafely("123"));
        assertNull(ExceptionsDemo.parseIntSafely("abc"));
        assertNull(ExceptionsDemo.parseIntSafely(""));
    }
    
    @Test
    @DisplayName("readFile should handle non-existent file")
    void testReadFile() {
        String result = ExceptionsDemo.readFile("nonexistent.txt");
        assertTrue(result.contains("File not found") || result.contains("Error reading"));
    }
    
    @Test
    @DisplayName("Custom exception should have message")
    void testCustomExceptionMessage() {
        InvalidAgeException exception = new InvalidAgeException("Test message");
        assertEquals("Test message", exception.getMessage());
    }
}
