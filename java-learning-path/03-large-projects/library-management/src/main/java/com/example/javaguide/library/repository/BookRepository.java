package com.example.javaguide.library.repository;

import com.example.javaguide.library.model.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Repository for Book persistence using JSON
 */
public class BookRepository {
    private final String filePath;
    private final Gson gson;
    private Map<String, Book> books;
    
    public BookRepository(String filePath) {
        this.filePath = filePath;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.books = new HashMap<>();
        loadBooks();
    }
    
    public void save(Book book) {
        books.put(book.getIsbn(), book);
        persist();
    }
    
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }
    
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
    
    public List<Book> findByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }
    
    public List<Book> findByAuthor(String author) {
        return books.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();
    }
    
    public void delete(String isbn) {
        books.remove(isbn);
        persist();
    }
    
    private void loadBooks() {
        File file = new File(filePath);
        if (!file.exists()) return;
        
        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<Map<String, Book>>(){}.getType();
            Map<String, Book> loaded = gson.fromJson(reader, type);
            if (loaded != null) {
                books = loaded;
            }
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
    }
    
    private void persist() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(books, writer);
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }
}
