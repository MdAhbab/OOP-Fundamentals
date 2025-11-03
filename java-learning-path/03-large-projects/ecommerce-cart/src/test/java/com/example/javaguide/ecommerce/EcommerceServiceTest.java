package com.example.javaguide.ecommerce;

import com.example.javaguide.ecommerce.model.*;
import com.example.javaguide.ecommerce.payment.*;
import com.example.javaguide.ecommerce.service.EcommerceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class EcommerceServiceTest {
    
    @Test
    @DisplayName("Should add items to cart")
    void testAddToCart() {
        ShoppingCart cart = new ShoppingCart("user1");
        Product product = new Product("TEST", "Test Product", 99.99);
        
        cart.addItem(product, 2);
        
        assertEquals(1, cart.getItemCount());
        assertEquals(199.98, cart.getSubtotal(), 0.01);
    }
    
    @Test
    @DisplayName("Should calculate cart total correctly")
    void testCartTotal() {
        ShoppingCart cart = new ShoppingCart("user1");
        Product p1 = new Product("P1", "Product 1", 50.0);
        Product p2 = new Product("P2", "Product 2", 30.0);
        
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);
        
        assertEquals(110.0, cart.getSubtotal(), 0.01);
        
        cart.applyDiscount(10.0);
        assertEquals(100.0, cart.getTotal(), 0.01);
    }
    
    @Test
    @DisplayName("Should process checkout successfully")
    void testCheckout() {
        EcommerceService service = EcommerceService.getInstance();
        ShoppingCart cart = new ShoppingCart("user1");
        
        Product product = service.getProduct("P002").orElseThrow();
        cart.addItem(product, 1);
        
        PaymentStrategy payment = new CreditCardPayment("1234", "123");
        Order order = service.checkout(cart, payment);
        
        assertNotNull(order);
        assertEquals(Order.OrderStatus.CONFIRMED, order.getStatus());
        assertEquals(0, cart.getItemCount());
    }
    
    @Test
    @DisplayName("Should search products")
    void testSearchProducts() {
        EcommerceService service = EcommerceService.getInstance();
        var results = service.searchProducts("Mouse");
        
        assertFalse(results.isEmpty());
        assertTrue(results.get(0).getName().contains("Mouse"));
    }
}
