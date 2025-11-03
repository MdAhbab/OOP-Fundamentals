package com.example.javaguide.setup;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SetupDemo
 * 
 * Demonstrates JUnit 5 testing basics:
 * - Test annotations
 * - Assertions
 * - Test naming conventions
 */
class SetupDemoTest {
    
    @Test
    @DisplayName("Basic calculation should return correct sum")
    void testPerformBasicCalculation() {
        // Arrange
        int a = 10;
        int b = 5;
        int expected = 15;
        
        // Act
        int actual = SetupDemo.performBasicCalculation(a, b);
        
        // Assert
        assertEquals(expected, actual, "10 + 5 should equal 15");
    }
    
    @Test
    @DisplayName("Java version should not be null or empty")
    void testGetJavaVersion() {
        // Act
        String javaVersion = SetupDemo.getJavaVersion();
        
        // Assert
        assertNotNull(javaVersion, "Java version should not be null");
        assertFalse(javaVersion.isEmpty(), "Java version should not be empty");
    }
    
    @Test
    @DisplayName("Should detect Java 17 or higher")
    void testIsJava17OrHigher() {
        // Act
        boolean isJava17Plus = SetupDemo.isJava17OrHigher();
        
        // Assert
        assertTrue(isJava17Plus, "This project requires Java 17 or higher");
    }
    
    @Test
    @DisplayName("Basic calculation with negative numbers")
    void testPerformBasicCalculationWithNegativeNumbers() {
        // Test with negative numbers
        assertEquals(-5, SetupDemo.performBasicCalculation(-10, 5));
        assertEquals(-15, SetupDemo.performBasicCalculation(-10, -5));
        assertEquals(5, SetupDemo.performBasicCalculation(10, -5));
    }
    
    @Test
    @DisplayName("Basic calculation with zero")
    void testPerformBasicCalculationWithZero() {
        // Test with zero
        assertEquals(10, SetupDemo.performBasicCalculation(10, 0));
        assertEquals(0, SetupDemo.performBasicCalculation(0, 0));
    }
}
