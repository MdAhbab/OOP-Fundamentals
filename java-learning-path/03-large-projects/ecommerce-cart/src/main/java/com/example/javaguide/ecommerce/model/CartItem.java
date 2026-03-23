package com.example.javaguide.ecommerce.model;

/**
 * Granular mapping component describing dynamic temporary selections storing distinct product variants sequentially.
 */
public class CartItem {
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
