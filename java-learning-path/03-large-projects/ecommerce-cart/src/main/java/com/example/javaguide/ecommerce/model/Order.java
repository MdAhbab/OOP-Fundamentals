package com.example.javaguide.ecommerce.model;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String paymentMethod;
    
    public enum OrderStatus {
        PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    }
    
    public Order(String userId, List<OrderItem> items, double totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDateTime.now();
    }
    
    public void confirm() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Can only confirm pending orders");
        }
        this.status = OrderStatus.CONFIRMED;
    }
    
    public void cancel() {
        if (status == OrderStatus.DELIVERED) {
            throw new IllegalStateException("Cannot cancel delivered orders");
        }
        this.status = OrderStatus.CANCELLED;
    }
    
    // Getters and setters
    public String getOrderId() { return orderId; }
    public String getUserId() { return userId; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String method) { this.paymentMethod = method; }
    
    @Override
    public String toString() {
        return String.format("Order{id='%s', user='%s', total=%.2f, status=%s, items=%d}",
                orderId, userId, totalAmount, status, items.size());
    }
}

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
