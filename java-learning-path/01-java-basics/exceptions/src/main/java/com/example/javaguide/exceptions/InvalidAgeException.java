package com.example.javaguide.exceptions;

/**
 * Custom checked exception
 * Extends Exception (must be caught or declared)
 */
public class InvalidAgeException extends Exception {
    
    public InvalidAgeException(String message) {
        super(message);
    }
    
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
