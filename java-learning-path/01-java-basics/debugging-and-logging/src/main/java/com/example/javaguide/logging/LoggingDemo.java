package com.example.javaguide.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingDemo - Demonstrates standard logging pipelines with SLF4J in Java.
 * 
 * SLF4J (Simple Logging Facade for Java) acts as a facade across various parsing frameworks,
 * allowing end users unified usage structures irrespective of background component differences.
 * This class covers:
 * - Fundamental log levels
 * - Correct usage paradigms via parametrics (vs standard string implementations)
 * - Error documentation through localized structural mechanisms
 */
public class LoggingDemo {
    
    // Establishing logger static access via LoggerFactory linking to enclosing instance definitions
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
    
    /**
     * Centralized execution component.
     */
    public static void main(String[] args) {
        demonstrateLogLevels();
        demonstrateParameterizedLogging();
        demonstrateExceptionLogging();
        processUserRequest("user123", "getData");
    }
    /**
     * Represents the hierarchal precedence for standardized core output configurations.
     */
    public static void demonstrateLogLevels() {
        logger.trace("TRACE: Very detailed information");
        logger.debug("DEBUG: Debugging information");
        logger.info("INFO: Informational message");
        logger.warn("WARN: Warning message");
        logger.error("ERROR: Error message");
    }
    /**
     * Recommends avoiding hard string concatenations via SLF4J brackets.
     * Decreases memory loads structurally since internal operations format texts
     * relative inherently to active enabled log thresholds.
     */
    public static void demonstrateParameterizedLogging() {
        String user = "Alice";
        int age = 25;
        
        // Good: Uses placeholders (no string concatenation)
        logger.info("User {} is {} years old", user, age);
        
        // Bad: String concatenation (avoid this)
        // logger.info("User " + user + " is " + age + " years old");
    }
    /**
     * Showcases attaching actual Exception traces uniformly.
     */
    public static void demonstrateExceptionLogging() {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            logger.error("Division error occurred", e);
        }
    }
    /**
     * Utility illustrating localized operations utilizing debug tags.
     * 
     * @param a The generic numerator variable element
     * @param b The localized generic denominator element
     * @return Execution output of mathematical target calculations
     */
    public static int divide(int a, int b) {
        logger.debug("Dividing {} by {}", a, b);
        return a / b;
    }
    /**
     * Processes requests against user structures recording progress across the system format timeline.
     * 
     * @param userId Tracking key indicating origin element sequences
     * @param action Command description text referencing requested operational modes
     */
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
    /**
     * Displays deeper logging hierarchies by capturing entering inputs structurally before returning.
     * 
     * @param a Main component arithmetic scalar
     * @param b Optional parameter operand numeric structural value
     */
    public static void calculateWithLogging(int a, int b) {
        logger.trace("Entering calculateWithLogging: a={}, b={}", a, b);
        
        int sum = a + b;
        logger.debug("Calculated sum: {}", sum);
        
        int product = a * b;
        logger.debug("Calculated product: {}", product);
        
        logger.trace("Exiting calculateWithLogging");
    }
}
