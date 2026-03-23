package com.example.javaguide.ecommerce.model;

import java.util.*;

/**
 * Encapsulates volatile shopping accumulations globally tying active combinations specifically targeting temporary staging phases generically.
 */
public class ShoppingCart {
    private String cartId;
    private String userId;
    private Map<String, CartItem> items;
    private double discountAmount;
    
    /**
     * Constructs fresh mapping targets referencing parent entities explicitly generating new IDs sequentially structurally.
     */
    public ShoppingCart(String userId) {
        this.cartId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = new HashMap<>();
        this.discountAmount = 0.0;
    }
    
    /**
     * Parses combination inclusions mapping structural objects validating components dynamically merging duplicates explicitly inherently natively.
     */
    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        String productId = product.getProductId();
        if (items.containsKey(productId)) {
            CartItem item = items.get(productId);
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            items.put(productId, new CartItem(product, quantity));
        }
    }
    
    /**
     * Clears tracked selections entirely targeting exact referenced mapped identities structurally.
     */
    public void removeItem(String productId) {
        items.remove(productId);
    }
    
    /**
     * Formats nested quantity sequences parsing elements safely validating negative fallbacks directly conditionally dynamically mechanically.
     */
    public void updateItemQuantity(String productId, int quantity) {
        if (quantity <= 0) {
            removeItem(productId);
            return;
        }
        
        CartItem item = items.get(productId);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }
    
    /**
     * Recombines sum bounds generically iterating over active target properties dynamically mapping structural totals exclusively mathematically natively.
     */
    public double getSubtotal() {
        return items.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
    
    /**
     * Translates final total bounds applying discount variations mathematically returning strict non-negative sums dynamically mathematically inherently natively.
     */
    public double getTotal() {
        return Math.max(0, getSubtotal() - discountAmount);
    }
    
    public void applyDiscount(double amount) {
        this.discountAmount = amount;
    }
    
    public void clear() {
        items.clear();
        discountAmount = 0.0;
    }
    
    public String getCartId() { return cartId; }
    public String getUserId() { return userId; }
    public Map<String, CartItem> getItems() { return new HashMap<>(items); }
    public double getDiscountAmount() { return discountAmount; }
    public int getItemCount() { return items.size(); }
}

