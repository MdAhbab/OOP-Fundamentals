package com.example.javaguide.library;

import com.example.javaguide.library.model.*;
import com.example.javaguide.library.service.LibraryService;

import java.util.List;
import java.util.Scanner;

/**
 * LibraryApp - CLI orchestration gateway controlling interactive input states globally natively.
 * 
 * Maps structural menu interfaces into discrete LibraryService business routines dynamically.
 */
public class LibraryApp {
    private static final LibraryService library = LibraryService.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * Initializes default configuration and boots structural interaction loops infinitely.
     */
    public static void main(String[] args) {
        initializeData();
        runCLI();
    }
    
    /**
     * Prepopulates staging repositories generating verifiable seed data testing parameters cleanly explicitly.
     */
    private static void initializeData() {
        // Add sample books
        library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("978-0596009205", "Head First Java", "Kathy Sierra", 2005));
        library.addBook(new Book("978-0135166307", "Java Concurrency in Practice", "Brian Goetz", 2006));
        
        // Register sample members
        library.registerMember(new Member("M001", "Alice Johnson"));
        library.registerMember(new Member("M002", "Bob Smith"));
    }
    
    /**
     * Defines primary interactive event listener parsing numerical choices redirecting explicitly natively.
     */
    private static void runCLI() {
        System.out.println("=== Library Management System ===\n");
        
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            
            try {
                switch (choice) {
                    case "1" -> listAllBooks();
                    case "2" -> searchBooks();
                    case "3" -> borrowBook();
                    case "4" -> returnBook();
                    case "5" -> addBook();
                    case "6" -> registerMember();
                    case "0" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            
            System.out.println();
        }
    }
    
    /**
     * Renders standard operational choices outputting formatted text visually.
     */
    private static void displayMenu() {
        System.out.println("""
                1. List all books
                2. Search books
                3. Borrow book
                4. Return book
                5. Add book
                6. Register member
                0. Exit
                
                Enter choice:\s""");
    }
    
    /**
     * Pulls sequential catalogue entries mapping text values universally directly structurally correctly.
     */
    private static void listAllBooks() {
        List<Book> books = library.getAllBooks();
        System.out.println("\n--- All Books ---");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            books.forEach(System.out::println);
        }
    }
    
    /**
     * Queries matching entries splitting searches dynamically conditionalizing targets correctly logically natively.
     */
    private static void searchBooks() {
        System.out.print("Search by (1) Title or (2) Author: ");
        String type = scanner.nextLine().trim();
        
        System.out.print("Enter search term: ");
        String term = scanner.nextLine().trim();
        
        List<Book> results = type.equals("1") 
                ? library.searchBooksByTitle(term)
                : library.searchBooksByAuthor(term);
        
        System.out.println("\n--- Search Results ---");
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            results.forEach(System.out::println);
        }
    }
    
    /**
     * Orchestrates structural checks mapping users explicitly initiating checkout validation explicitly statically mechanically.
     */
    private static void borrowBook() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();
        
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        String loanId = library.borrowBook(memberId, isbn);
        System.out.println("Book borrowed successfully. Loan ID: " + loanId);
    }
    
    /**
     * Handles returning phases confirming tracking parameters safely directly synchronously natively.
     */
    private static void returnBook() {
        System.out.print("Enter loan ID: ");
        String loanId = scanner.nextLine().trim();
        
        library.returnBook(loanId);
        System.out.println("Book returned successfully.");
    }
    
    /**
     * Gathers component descriptors verifying values mapping inventory entities explicitly correctly structurally natively.
     */
    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine().trim();
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine().trim();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine().trim();
        
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine().trim());
        
        Book book = new Book(isbn, title, author, year);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }
    
    /**
     * Parses account components generating tracked target memberships universally fundamentally seamlessly explicitly structurally natively.
     */
    private static void registerMember() {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine().trim();
        
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        
        Member member = new Member(memberId, name);
        library.registerMember(member);
        System.out.println("Member registered successfully.");
    }
}
