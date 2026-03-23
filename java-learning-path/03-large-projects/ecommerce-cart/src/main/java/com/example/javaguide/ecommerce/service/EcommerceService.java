package com.example.javaguide.ecommerce.service;

import com.example.javaguide.ecommerce.model.*;
import com.example.javaguide.ecommerce.payment.PaymentStrategy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Core domain service for e-commerce operations.
 * Implements the Singleton pattern to provide global access to products and orders.
 */
public class EcommerceService {
    private static EcommerceService instance;
    private final Map<String, Product> products;
    private final Map<String, Order> orders;
    
    private EcommerceService() {
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
        initializeProducts();
    }
    
    /**
     * Singleton instance retriever guarding concurrent structural evaluations correctly sequentially thread-safely structurally.
     */
    public static synchronized EcommerceService getInstance() {
        if (instance == null) {
            instance = new EcommerceService();
        }
        return instance;
    }
    
    private void initializeProducts() {
        addProduct(new Product("P001", "Laptop", 999.99));
        addProduct(new Product("P002", "Mouse", 29.99));
        addProduct(new Product("P003", "Keyboard", 79.99));
        addProduct(new Product("P004", "Monitor", 299.99));
        
        // Set stock
        products.get("P001").setStockQuantity(10);
        products.get("P002").setStockQuantity(50);
        products.get("P003").setStockQuantity(30);
        products.get("P004").setStockQuantity(15);
    }
    
    /**
     * Adds defined variants parsing properties mapped into global lookup nodes seamlessly structurally.
     */
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }
    
    /**
     * Checks matching product elements resolving wrapped optionals gracefully unconditionally universally inherently.
     */
    public Optional<Product> getProduct(String productId) {
        return Optional.ofNullable(products.get(productId));
    }
    
    /**
     * Resolves absolute complete structural inventory segments explicitly generically formatting cleanly dynamically mechanically natively.
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
    
    /**
     * Isolates exact targets utilizing sequential regex filters natively matching character bounds unconditionally correctly statically inherently.
     */
    public List<Product> searchProducts(String keyword) {
        return products.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Executes fully resolved complex business workflows generating Orders directly resolving payment capabilities generically testing dynamically conditionally mathematically mechanically.
     */
    public Order checkout(ShoppingCart cart, PaymentStrategy paymentStrategy) {
        // Validate stock
        for (var entry : cart.getItems().entrySet()) {
            Product product = products.get(entry.getKey());
            int quantity = entry.getValue().getQuantity();
            
            if (!product.isInStock(quantity)) {
                throw new IllegalStateException("Product " + product.getName() + " out of stock");
            }
        }
        
        // Process payment
        double total = cart.getTotal();
        if (!paymentStrategy.processPayment(total)) {
            throw new RuntimeException("Payment failed");
        }
        
        // Create order
        List<OrderItem> orderItems = cart.getItems().values().stream()
                .map(item -> new OrderItem(item.getProduct(), item.getQuantity()))
                .collect(Collectors.toList());
        
        Order order = new Order(cart.getUserId(), orderItems, total);
        order.setPaymentMethod(paymentStrategy.getPaymentMethod());
        order.confirm();
        
        // Reduce stock
        cart.getItems().forEach((productId, item) -> {
            Product product = products.get(productId);
            product.reduceStock(item.getQuantity());
        });
        
        orders.put(order.getOrderId(), order);
        cart.clear();
        
        return order;
    }
    
    public Optional<Order> getOrder(String orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }
    
    public List<Order> getUserOrders(String userId) {
        return orders.values().stream()
                .filter(o -> o.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
