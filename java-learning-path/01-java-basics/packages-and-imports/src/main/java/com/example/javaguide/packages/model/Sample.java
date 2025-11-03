package com.example.javaguide.packages.model;

/**
 * Sample class in model sub-package
 * Demonstrates package organization for domain models
 */
public class Sample {
    
    private String value;
    
    public Sample(String value) {
        this.value = value;
    }
    public Sample(String value, int id) {
        this.value = "default";
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Sample{value='" + value + "'}";
    }
}
