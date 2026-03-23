package com.example.javaguide.ecommerce.payment;

/**
 * Captures external email verification routing algorithms structurally managing payload components via generic services directly.
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + email);
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}
