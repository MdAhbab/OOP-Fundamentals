package com.example.javaguide.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingDemo - Demonstrates SLF4J logging
 */
public class LoggingDemo {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
    
    public static void main(String[] args) {
        demonstrateLogLevels();
        demonstrateParameterizedLogging();
        demonstrateExceptionLogging();
        processUserRequest("user123", "getData");
    }
    
    public static void demonstrateLogLevels() {
        logger.trace("TRACE: Very detailed information");
        logger.debug("DEBUG: Debugging information");
        logger.info("INFO: Informational message");
        logger.warn("WARN: Warning message");
        logger.error("ERROR: Error message");
    }
    
    public static void demonstrateParameterizedLogging() {
        String user = "Alice";
        int age = 25;
        
        // Good: Uses placeholders (no string concatenation)
        logger.info("User {} is {} years old", user, age);
        
        // Bad: String concatenation (avoid this)
        // logger.info("User " + user + " is " + age + " years old");
    }
    
    public static void demonstrateExceptionLogging() {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            logger.error("Division error occurred", e);
        }
    }
    
    public static int divide(int a, int b) {
        logger.debug("Dividing {} by {}", a, b);
        return a / b;
    }
    
    public static void processUserRequest(String userId, String action) {
        logger.info("Processing request - User: {}, Action: {}", userId, action);
        
        try {
            // Simulate processing
            Thread.sleep(100);
            logger.debug("Request processed successfully for user: {}", userId);
        } catch (InterruptedException e) {
            logger.error("Request processing interrupted for user: {}", userId, e);
            Thread.currentThread().interrupt();
        }
    }
    
    public static void calculateWithLogging(int a, int b) {
        logger.trace("Entering calculateWithLogging: a={}, b={}", a, b);
        
        int sum = a + b;
        logger.debug("Calculated sum: {}", sum);
        
        int product = a * b;
        logger.debug("Calculated product: {}", product);
        
        logger.trace("Exiting calculateWithLogging");
    }
}
