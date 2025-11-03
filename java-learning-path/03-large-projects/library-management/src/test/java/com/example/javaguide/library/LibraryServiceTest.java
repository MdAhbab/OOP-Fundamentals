package com.example.javaguide.library;

import com.example.javaguide.library.model.*;
import com.example.javaguide.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    private LibraryService library;
    
    @BeforeEach
    void setUp() {
        library = LibraryService.getInstance();
    }
    
    @Test
    @DisplayName("Should add and find book")
    void testAddAndFindBook() {
        Book book = new Book("123", "Test Book", "Test Author", 2024);
        library.addBook(book);
        
        var found = library.findBook("123");
        assertTrue(found.isPresent());
        assertEquals("Test Book", found.get().getTitle());
    }
    
    @Test
    @DisplayName("Should register and find member")
    void testRegisterAndFindMember() {
        Member member = new Member("M999", "Test User");
        library.registerMember(member);
        
        var found = library.findMember("M999");
        assertTrue(found.isPresent());
        assertEquals("Test User", found.get().getName());
    }
    
    @Test
    @DisplayName("Should borrow and return book")
    void testBorrowAndReturn() {
        Book book = new Book("456", "Borrowable", "Author", 2024);
        library.addBook(book);
        
        Member member = new Member("M888", "Borrower");
        library.registerMember(member);
        
        String loanId = library.borrowBook("M888", "456");
        assertNotNull(loanId);
        
        // Book should be borrowed
        var borrowedBook = library.findBook("456");
        assertEquals(Book.BookStatus.BORROWED, borrowedBook.get().getStatus());
        
        // Return book
        library.returnBook(loanId);
        var returnedBook = library.findBook("456");
        assertEquals(Book.BookStatus.AVAILABLE, returnedBook.get().getStatus());
    }
    
    @Test
    @DisplayName("Should search books by title")
    void testSearchByTitle() {
        library.addBook(new Book("111", "Java Programming", "Author1", 2024));
        library.addBook(new Book("222", "Python Programming", "Author2", 2024));
        
        var results = library.searchBooksByTitle("Java");
        assertEquals(1, results.size());
        assertEquals("Java Programming", results.get(0).getTitle());
    }
}
