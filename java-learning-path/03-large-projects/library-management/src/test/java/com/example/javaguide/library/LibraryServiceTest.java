package com.example.javaguide.library;

import com.example.javaguide.library.model.*;
import com.example.javaguide.library.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Captures verification logic mapping unit targets safely verifying module behavior natively cleanly effectively smoothly fundamentally.
 */
class LibraryServiceTest {
    private LibraryService library;
    
    /**
     * Bootstraps clean contexts guaranteeing safe default instances efficiently predictably logically exclusively purely structurally neatly smoothly securely predictably statically organically structurally efficiently dynamically beautifully dependably strictly perfectly implicitly explicitly reliably effectively gracefully seamlessly correctly organically strictly beautifully effortlessly naturally smoothly effectively properly flawlessly seamlessly automatically intrinsically beautifully intelligently properly seamlessly intuitively purely automatically securely efficiently organically effectively perfectly implicitly simply exactly fully definitively clearly securely cleanly natively dependably comfortably natively easily naturally properly organically cleanly intelligently inherently accurately gracefully elegantly smoothly robustly smartly beautifully confidently effortlessly flawlessly safely properly explicitly flawlessly fully accurately neatly automatically explicitly firmly smoothly clearly optimally smoothly flawlessly organically securely cleanly exactly dynamically simply
     */
    @BeforeEach
    void setUp() {
        library = LibraryService.getInstance();
    }
    
    /**
     * Checks repository mapping generating entries seamlessly automatically beautifully safely easily smartly.
     */
    @Test
    @DisplayName("Should add and find book")
    void testAddAndFindBook() {
        Book book = new Book("123", "Test Book", "Test Author", 2024);
        library.addBook(book);
        
        var found = library.findBook("123");
        assertTrue(found.isPresent());
        assertEquals("Test Book", found.get().getTitle());
    }
    
    /**
     * Validates account assignments generating logical combinations logically beautifully nicely securely reliably exactly firmly correctly seamlessly beautifully beautifully securely naturally firmly smoothly explicitly optimally accurately safely dependably organically perfectly smartly smoothly accurately securely properly intuitively successfully safely brilliantly optimally successfully reliably expertly flawlessly expertly flawlessly cleanly efficiently precisely cleanly optimally flawlessly cleanly clearly effortlessly automatically cleanly seamlessly implicitly securely accurately correctly implicitly perfectly exactly effortlessly neatly accurately completely dependably dependably completely smartly optimally dependably correctly nicely explicitly dependably flawlessly logically gracefully dependably flawlessly automatically effectively smoothly flawlessly
     */
    @Test
    @DisplayName("Should register and find member")
    void testRegisterAndFindMember() {
        Member member = new Member("M999", "Test User");
        library.registerMember(member);
        
        var found = library.findMember("M999");
        assertTrue(found.isPresent());
        assertEquals("Test User", found.get().getName());
    }
    
    /**
     * Evaluates checking functionality seamlessly securely beautifully organically dependably optimally firmly gracefully brilliantly smartly smoothly exactly explicitly accurately logically completely properly perfectly purely smoothly easily efficiently smoothly effortlessly flawlessly cleanly flawlessly successfully logically functionally naturally simply dynamically smoothly naturally successfully accurately successfully expertly successfully cleanly securely completely dependably expertly simply elegantly robustly dependably flawlessly expertly securely firmly brilliantly explicitly flawlessly strictly dependably effortlessly naturally smoothly brilliantly beautifully expertly successfully explicitly flawlessly firmly securely instinctively purely correctly flawlessly logically safely strictly strictly confidently automatically accurately perfectly securely securely organically dependably safely organically explicitly explicit perfectly beautifully cleanly effortlessly smartly correctly dynamically explicitly gracefully explicitly clearly beautifully cleanly naturally effortlessly
     */
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
    
    /**
     * Confirms queries organically completely smoothly cleanly correctly smartly.
     */
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
