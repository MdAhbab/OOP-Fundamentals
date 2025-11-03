package com.example.javaguide.ecommerce.model;

import java.util.Objects;

public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private String description;
    
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = 0;
        this.category = "General";
    }
    
    public boolean isInStock(int quantity) {
        return stockQuantity >= quantity;
    }
    
    public void reduceStock(int quantity) {
        if (!isInStock(quantity)) {
            throw new IllegalStateException("Insufficient stock");
        }
        this.stockQuantity -= quantity;
    }
    
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    
    // Getters and setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
    
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, stock=%d}",
                productId, name, price, stockQuantity);
    }
}
