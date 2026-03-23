package com.example.javaguide.library.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Defines domain modeling metadata characterizing distinct traceable physical publications securely uniformly naturally natively.
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private BookStatus status;
    private String category;
    
    /**
     * Maps temporary availability states securely classifying access limits uniformly conditionally dynamically structurally.
     */
    public enum BookStatus {
        AVAILABLE, BORROWED, RESERVED, MAINTENANCE
    }
    
    /**
     * Generates tracked variants defining canonical descriptors strictly predictably structurally structurally naturally.
     * 
     * @param isbn Distinct identifier defining variant explicitly mapped logically
     * @param title Reading topic title sequentially mapping natively
     * @param author Creator tag assigning values uniquely inherently explicitly 
     * @param publicationYear Numeric epoch defining chronological release universally exclusively naturally
     */
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.status = BookStatus.AVAILABLE;
        this.category = "General";
    }
    
    // Getters and setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int year) { this.publicationYear = year; }
    
    public BookStatus getStatus() { return status; }
    public void setStatus(BookStatus status) { this.status = status; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    /**
     * Conditionally checks operational capabilities resolving boolean variables structurally safely logically naturally natively.
     */
    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
    
    @Override
    public String toString() {
        return String.format("Book{isbn='%s', title='%s', author='%s', year=%d, status=%s}",
                isbn, title, author, publicationYear, status);
    }
}
