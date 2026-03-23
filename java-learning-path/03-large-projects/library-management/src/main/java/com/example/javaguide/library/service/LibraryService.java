package com.example.javaguide.library.service;

import com.example.javaguide.library.model.*;
import com.example.javaguide.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for the Library Management System.
 * Orchestrates operations between repositories and domain services,
 * managing books, members, and the borrowing/returning lifecycle.
 */
public class LibraryService {
    private static LibraryService instance;
    private final BookRepository bookRepository;
    private final LoanService loanService;
    private final MemberService memberService;
    
    private LibraryService() {
        this.bookRepository = new BookRepository("data/books.json");
        this.loanService = new LoanService();
        this.memberService = new MemberService();
    }
    
    /**
     * Pulls sequential contexts.
     */
    public static synchronized LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }
    
    // Book operations
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    
    public Optional<Book> findBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    
    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    // Member operations
    public void registerMember(Member member) {
        memberService.addMember(member);
    }
    
    public Optional<Member> findMember(String memberId) {
        return memberService.findById(memberId);
    }
    
    // Loan operations
    /**
     * Processes a book borrowing request.
     */
    public String borrowBook(String memberId, String isbn) {
        Member member = memberService.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book not available");
        }
        
        if (!member.canBorrowMore()) {
            throw new IllegalStateException("Member has reached borrowing limit");
        }
        
        String loanId = UUID.randomUUID().toString();
        Loan loan = new Loan(loanId, memberId, isbn);
        
        book.setStatus(Book.BookStatus.BORROWED);
        bookRepository.save(book);
        
        member.borrowBook(isbn);
        memberService.updateMember(member);
        
        loanService.addLoan(loan);
        
        return loanId;
    }
    
    /**
     * Processes a book returning request.
     */
    public void returnBook(String loanId) {
        Loan loan = loanService.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));
        
        Book book = bookRepository.findByIsbn(loan.getIsbn())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        
        Member member = memberService.findById(loan.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        
        loan.returnBook();
        loanService.updateLoan(loan);
        
        book.setStatus(Book.BookStatus.AVAILABLE);
        bookRepository.save(book);
        
        member.returnBook(loan.getIsbn());
        memberService.updateMember(member);
    }
}

// Supporting classes
class LoanService {
    private final java.util.Map<String, Loan> loans = new java.util.HashMap<>();
    
    public void addLoan(Loan loan) {
        loans.put(loan.getLoanId(), loan);
    }
    
    public Optional<Loan> findById(String loanId) {
        return Optional.ofNullable(loans.get(loanId));
    }
    
    public void updateLoan(Loan loan) {
        loans.put(loan.getLoanId(), loan);
    }
}

class MemberService {
    private final java.util.Map<String, Member> members = new java.util.HashMap<>();
    
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }
    
    public Optional<Member> findById(String memberId) {
        return Optional.ofNullable(members.get(memberId));
    }
    
    public void updateMember(Member member) {
        members.put(member.getMemberId(), member);
    }
}
