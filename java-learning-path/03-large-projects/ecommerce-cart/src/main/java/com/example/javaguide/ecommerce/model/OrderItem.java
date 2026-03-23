package com.example.javaguide.ecommerce.model;

/**
 * Entity mapping singular distinct purchases tying quantity components safely directly without mutating core objects natively.
 */
public class OrderItem {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    
    public OrderItem(Product product, int quantity) {
        this.productId = product.getProductId();
        this.productName = product.getName();
        this.price = product.getPrice();
        this.quantity = quantity;
    }
    
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public double getSubtotal() {
        return price * quantity;
    }
}
