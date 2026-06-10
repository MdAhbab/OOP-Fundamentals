package com.example.javaguide.logging;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class LoggingTest {
    
    @Test
    @DisplayName("Division should throw exception on divide by zero")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> {
            LoggingDemo.divide(10, 0);
        });
    }
    
    @Test
    @DisplayName("Division should work correctly")
    void testDivideNormal() {
        int result = LoggingDemo.divide(10, 2);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Process request should complete without errors")
    void testProcessUserRequest() {
        assertDoesNotThrow(() -> {
            LoggingDemo.processUserRequest("testUser", "testAction");
        });
    }
}
