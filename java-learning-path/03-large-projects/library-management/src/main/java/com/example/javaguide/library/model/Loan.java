package com.example.javaguide.library.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a transaction record for a borrowed book.
 */
public class Loan {
    private String loanId;
    private String memberId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;
    
    /**
     * Tracks the current state of a loan.
     */
    public enum LoanStatus {
        ACTIVE, RETURNED, OVERDUE, RENEWED
    }
    
    /**
     * Initializes a new loan record with a 2-week due date.
     * 
     * @param loanId Unique transaction ID.
     * @param memberId ID of the borrowing member.
     * @param isbn ISBN of the borrowed book.
     */
    public Loan(String loanId, String memberId, String isbn) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.isbn = isbn;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14); // 2 weeks
        this.status = LoanStatus.ACTIVE;
    }
    
    /**
     * Checks if the current loan has exceeded its due date.
     */
    public boolean isOverdue() {
        return status == LoanStatus.ACTIVE && LocalDate.now().isAfter(dueDate);
    }
    
    /**
     * Updates the loan status to RETURNED and records the current date.
     */
    public void returnBook() {
        this.returnDate = LocalDate.now();
        this.status = LoanStatus.RETURNED;
    }
    
    /**
     * Re-initializes the due date for another 14 days.
     */
    public void renewLoan() {
        if (status != LoanStatus.ACTIVE) {
            throw new IllegalStateException("Can only renew active loans");
        }
        this.dueDate = this.dueDate.plusDays(14);
        this.status = LoanStatus.RENEWED;
    }
    
    /**
     * Calculates the number of days between the due date and today.
     */
    public int getDaysOverdue() {
        if (!isOverdue()) return 0;
        return (int) java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }
    
    // Getters and setters
    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }
    
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate date) { this.borrowDate = date; }
    
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate date) { this.dueDate = date; }
    
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate date) { this.returnDate = date; }
    
    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(loanId, loan.loanId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(loanId);
    }
    
    @Override
    public String toString() {
        return String.format("Loan{id='%s', member='%s', isbn='%s', due=%s, status=%s}",
                loanId, memberId, isbn, dueDate, status);
    }
}
