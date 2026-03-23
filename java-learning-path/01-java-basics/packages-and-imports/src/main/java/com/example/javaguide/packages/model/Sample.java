package com.example.javaguide.packages.model;

/**
 * Sample class in model sub-package.
 * Demonstrates package organisation for domain models
 * and constructor overloading within a model class.
 */
public class Sample {

    private String value; // The data held by this model

    /**
     * Constructs a Sample with the given value.
     *
     * @param value the initial value
     */
    public Sample(String value) {
        this.value = value;
    }

    /**
     * Overloaded constructor that combines value and id into a single string.
     * Useful when a unique composite identifier is needed.
     *
     * @param value base value string
     * @param id    numeric identifier appended to the value
     */
    public Sample(String value, int id) {
        // Combine both parameters so neither is wasted
        this.value = value + "#" + id;
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
