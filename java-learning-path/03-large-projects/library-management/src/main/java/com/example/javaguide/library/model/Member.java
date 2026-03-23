package com.example.javaguide.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a library member with their associated data and borrowing rules.
 */
public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private LocalDate memberSince;
    private MembershipType membershipType;
    private List<String> borrowedBooks; // ISBNs
    
    /**
     * Defines the limits for different membership tiers.
     */
    public enum MembershipType {
        BASIC(3),      // Can borrow 3 books
        PREMIUM(5),    // Can borrow 5 books
        VIP(10);       // Can borrow 10 books
        
        private final int maxBooks;
        
        MembershipType(int maxBooks) {
            this.maxBooks = maxBooks;
        }
        
        public int getMaxBooks() {
            return maxBooks;
        }
    }
    
    /**
     * Constructs a new Member with basic defaults.
     * 
     * @param memberId Unique identifier for the member.
     * @param name Full name of the member.
     */
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.memberSince = LocalDate.now();
        this.membershipType = MembershipType.BASIC;
        this.borrowedBooks = new ArrayList<>();
    }
    
    /**
     * Checks if the member can borrow more books based on their membership type.
     */
    public boolean canBorrowMore() {
        return borrowedBooks.size() < membershipType.getMaxBooks();
    }
    
    /**
     * Records a book borrowing event for this member.
     */
    public void borrowBook(String isbn) {
        if (!canBorrowMore()) {
            throw new IllegalStateException("Maximum books limit reached");
        }
        borrowedBooks.add(isbn);
    }
    
    /**
     * Records a book return event for this member.
     */
    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }
    
    // Getters and setters
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public LocalDate getMemberSince() { return memberSince; }
    
    public MembershipType getMembershipType() { return membershipType; }
    public void setMembershipType(MembershipType type) { this.membershipType = type; }
    
    public List<String> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
    
    @Override
    public String toString() {
        return String.format("Member{id='%s', name='%s', type=%s, borrowed=%d}",
                memberId, name, membershipType, borrowedBooks.size());
    }
}
