package com.example.javaguide.ecommerce.payment;

/**
 * Implements standard credit verification routines mathematically conforming standard transaction protocols dynamically.
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    
    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " using card ending in " + 
            (cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber));
        // In a real app, CVV would be used here securely
        return true;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    @Override
    public String toString() {
        return "CreditCardPayment{card='****" + 
            (cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber) + 
            "', cvv='***'}";
    }
}
