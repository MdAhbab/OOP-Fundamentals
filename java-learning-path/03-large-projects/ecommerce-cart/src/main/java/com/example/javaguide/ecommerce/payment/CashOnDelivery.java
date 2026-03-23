package com.example.javaguide.ecommerce.payment;

/**
 * Implements fallback mechanisms ignoring digital boundaries deferring physical fulfillment strictly mechanically securely natively.
 */
public class CashOnDelivery implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Cash on delivery selected. Amount: $" + amount);
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Cash on Delivery";
    }
}
