package com.example.javaguide.ecommerce.payment;

/**
 * Strategy pattern for payment processing
 */
public interface PaymentStrategy {
    boolean processPayment(double amount);
    String getPaymentMethod();
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    
    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Simulate payment processing
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class PayPalPayment implements PaymentStrategy {
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

class CashOnDelivery implements PaymentStrategy {
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
