package com.example.javaguide.ecommerce.payment;

/**
 * Strategy pattern interface governing abstract payment processing.
 * Separates core algorithms structurally determining correct transaction flows polymorphically natively.
 */
public interface PaymentStrategy {
    boolean processPayment(double amount);
    String getPaymentMethod();
}

