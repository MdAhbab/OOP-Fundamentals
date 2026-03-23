package com.example.javaguide.exceptions;

/**
 * InvalidAgeException - A custom checked exception component.
 * 
 * Extends the root Exception class. Since it doesn't extend RuntimeException, 
 * methods exposing this component natively must either be caught or declared.
 */
public class InvalidAgeException extends Exception {
    
    /**
     * Constructs a generic invalid age exception with the specific violation message.
     * 
     * @param message Textural data describing structural failure modes
     */
    public InvalidAgeException(String message) {
        super(message);
    }
    /**
     * Constructs the specific customized exception wrapped along 
     * preexisting standard exception causality sequences (exception chaining).
     * 
     * @param message Core response indicating what happened
     * @param cause Standard source causing the initial failure
     */
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
