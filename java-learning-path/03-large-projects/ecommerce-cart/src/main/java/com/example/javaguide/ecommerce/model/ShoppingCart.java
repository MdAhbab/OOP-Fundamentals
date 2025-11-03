package com.example.javaguide.ecommerce.model;

import java.util.*;

public class ShoppingCart {
    private String cartId;
    private String userId;
    private Map<String, CartItem> items;
    private double discountAmount;
    
    public ShoppingCart(String userId) {
        this.cartId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = new HashMap<>();
        this.discountAmount = 0.0;
    }
    
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
    
    public void removeItem(String productId) {
        items.remove(productId);
    }
    
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
    
    public double getSubtotal() {
        return items.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
    
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

class CartItem {
    private Product product;
    private int quantity;
    
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
