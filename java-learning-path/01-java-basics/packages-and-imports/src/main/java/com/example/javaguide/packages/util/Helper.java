package com.example.javaguide.packages.util;

/**
 * Helper class in util sub-package
 * Demonstrates package organization
 */
public class Helper {
    
    public void printMessage(String message) {
        System.out.println("Helper says: " + message);
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public String format(String text) {
        return "[" + text + "]";
    }
}
