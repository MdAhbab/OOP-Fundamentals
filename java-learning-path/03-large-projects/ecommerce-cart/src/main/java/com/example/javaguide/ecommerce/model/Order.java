package com.example.javaguide.ecommerce.model;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Describes finalized checkout receipts capturing comprehensive metadata defining immutable order combinations generically.
 */
public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String paymentMethod;
    
    /**
     * Tracks transitional order states determining downstream fulfillment progress sequentially.
     */
    public enum OrderStatus {
        PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    }
    
    /**
     * Constructs a pending order representation initialized globally.
     * 
     * @param userId Initiating client target explicitly mapped natively
     * @param items Sub-entities accumulated during cart mapping stages
     * @param totalAmount Float value resolving parsed aggregated costs specifically
     */
    public Order(String userId, List<OrderItem> items, double totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = new ArrayList<>(items);
        this.totalAmount = totalAmount;
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDateTime.now();
    }
    
    /**
     * Validates and advances state markers initiating further packaging operations correctly.
     */
    public void confirm() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Can only confirm pending orders");
        }
        this.status = OrderStatus.CONFIRMED;
    }
    
    /**
     * Terminates existing order transitions checking illegal completion thresholds gracefully conditionally.
     */
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

