package com.example.javaguide.testing;

/**
 * Calculator - Simple mathematical utility component for demonstration mapping testing structures natively.
 * 
 * Outlines fundamental capabilities representing testing targets correctly without overly complex constraints.
 */
public class Calculator {
    
    /**
     * Combines generic integers mathematically.
     * 
     * @param a Primary integer value target
     * @param b Sequential input adding sequentially statically
     * @return Combined representation mapping
     */
    public int add(int a, int b) {
        return a + b;
    }
    
    /**
     * Measures mathematical variation sequentially.
     * 
     * @param a Top value generically
     * @param b Minus generic calculation bound component
     * @return Target mathematically dynamically subtracted value globally 
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    
    /**
     * Generates multiple factors directly globally.
     * 
     * @param a Multiplicand parameter origin
     * @param b Multiplier targeted element correctly mapping values natively
     * @return Formatted resulting combined sequences
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Determines division constraints executing boundary checks universally stopping zero faults correctly statically dynamically.
     * 
     * @param a Top level dividend parameter
     * @param b Bottom divisor generic bounds correctly mapping references natively
     * @return Formatted float mapping division result 
     * @throws ArithmeticException whenever evaluating illegal operations
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }
    
    /**
     * Parses recursive loops computing mathematical factorials incrementally inherently.
     * 
     * @param n Positive parameter limit mapping factorial requirements precisely natively
     * @return Factorial computed limits structurally dynamically 
     * @throws IllegalArgumentException mapping invalid negative parameters directly 
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    /**
     * Mechanically measures elements correctly defining sequential divisibility inherently structurally validating mathematically natively prime layouts.
     * 
     * @param n Base bounds target correctly mapping natively
     * @return True structurally whenever parsing purely isolates elements correctly inherently via math logically linearly inherently.
     */
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
