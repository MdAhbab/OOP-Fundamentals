package com.example.javaguide.ecommerce;

import com.example.javaguide.ecommerce.model.*;
import com.example.javaguide.ecommerce.payment.*;
import com.example.javaguide.ecommerce.service.EcommerceService;

import java.util.Scanner;

/**
 * EcommerceApp - Main console application orchestrating the E-commerce cart system.
 * 
 * Demonstrates interactivity relying on the underlying EcommerceService singleton.
 * Handles CLI menus mapping selections to user interface operations natively.
 */
public class EcommerceApp {
    private static final EcommerceService service = EcommerceService.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static ShoppingCart cart = new ShoppingCart("user123");
    
    /**
     * Bootstraps the shopping cart interactive console interface loop.
     */
    public static void main(String[] args) {
        System.out.println("=== E-commerce Shopping Cart ===\n");
        
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            try {
                if (choice.equals("0")) {
                    System.out.println("Thank you for shopping!");
                    break;
                } else if (choice.equals("1")) {
                    listProducts();
                } else if (choice.equals("2")) {
                    addToCart();
                } else if (choice.equals("3")) {
                    viewCart();
                } else if (choice.equals("4")) {
                    checkout();
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.println();
        }
    }
    
    /**
     * Displays available terminal commands interactively.
     */
    private static void displayMenu() {
        System.out.println("1. List products\n2. Add to cart\n3. View cart\n4. Checkout\n0. Exit\n\nChoice: ");
    }
    
    /**
     * Retrieves and parses generic product mappings iterating available global inventory components natively.
     */
    private static void listProducts() {
        System.out.println("\n--- Products ---");
        service.getAllProducts().forEach(System.out::println);
    }
    
    /**
     * Prompts for product additions validating references matching correct inventory components securely.
     */
    private static void addToCart() {
        System.out.print("Product ID: ");
        String productId = scanner.nextLine().trim();
        
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine().trim());
        
        Product product = service.getProduct(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        
        cart.addItem(product, quantity);
        System.out.println("Added to cart!");
    }
    
    /**
     * Renders accumulated subtotal receipts itemizing current selections visually sequentially.
     */
    private static void viewCart() {
        System.out.println("\n--- Shopping Cart ---");
        if (cart.getItemCount() == 0) {
            System.out.println("Cart is empty");
            return;
        }
        
        cart.getItems().forEach((id, item) -> 
            System.out.printf("%s x%d = $%.2f\n", 
                item.getProduct().getName(), 
                item.getQuantity(), 
                item.getSubtotal()));
        
        System.out.printf("\nSubtotal: $%.2f\n", cart.getSubtotal());
        System.out.printf("Total: $%.2f\n", cart.getTotal());
    }
    
    /**
     * Orchestrates validation checks bridging payment gateways sequentially testing strategies generically correctly.
     */
    private static void checkout() {
        if (cart.getItemCount() == 0) {
            System.out.println("Cart is empty");
            return;
        }
        
        System.out.print("Payment method (1=Credit Card, 2=PayPal, 3=COD): ");
        String choice = scanner.nextLine().trim();
        
        PaymentStrategy payment = choice.equals("1") ? new CreditCardPayment("1234", "123")
                                : choice.equals("2") ? new PayPalPayment("user@example.com")
                                : new CashOnDelivery();
        
        Order order = service.checkout(cart, payment);
        System.out.println("Order placed: " + order);
    }
}
