"""
Library Service Module

Provides the main LibraryService class that orchestrates all library
operations including book management, member registration, and loan handling.
Uses the Singleton pattern to ensure a single instance across the application.
"""
from typing import Optional
import uuid
from ..models.book import Book, BookStatus
from ..models.member import Member, MembershipType
from ..models.loan import Loan, LoanStatus
from ..repository.book_repository import BookRepository


class LibraryService:
    """
    Main service class for library operations.

    Implements the Singleton pattern to ensure only one instance
    manages all library operations throughout the application.
    """
    _instance = None

    def __new__(cls):
        """Singleton implementation - ensures single instance."""
        if cls._instance is None:
            cls._instance = super(LibraryService, cls).__new__(cls)
            cls._instance._init_service()
        return cls._instance

    def _init_service(self):
        """Initialize internal state (called once on first instantiation)."""
        self.book_repo = BookRepository("data/books.json")
        self.members: dict[str, Member] = {}
        self.loans: dict[str, Loan] = {}

    def add_book(self, book: Book):
        """Add a new book to the library collection."""
        self.book_repo.save(book)

    def register_member(self, member: Member):
        """Register a new member in the library system."""
        self.members[member.member_id] = member

    def borrow_book(self, member_id: str, isbn: str) -> str:
        """
        Process a book borrowing transaction.

        Returns the loan_id. Raises ValueError if validation fails.
        """
        member = self.members.get(member_id)
        if not member: raise ValueError("Member not found")

        book = self.book_repo.find_by_isbn(isbn)
        if not book: raise ValueError("Book not found")

        if book.status != BookStatus.AVAILABLE:
            raise ValueError("Book is not available")

        if not member.can_borrow_more():
            raise ValueError("Member reached borrowing limit")

        # Create Loan record with unique 8-char ID
        loan_id = str(uuid.uuid4())[:8]
        loan = Loan(loan_id, member_id, isbn)
        self.loans[loan_id] = loan

        # Update book status and member's borrowed list
        book.status = BookStatus.BORROWED
        self.book_repo.save(book)
        member.borrow_book(isbn)

        return loan_id

    def return_book(self, loan_id: str):
        """Process a book return. Raises ValueError if loan not found."""
        loan = self.loans.get(loan_id)
        if not loan: raise ValueError("Loan not found")

        book = self.book_repo.find_by_isbn(loan.isbn)
        member = self.members.get(loan.member_id)

        # Update all statuses
        loan.status = LoanStatus.RETURNED
        book.status = BookStatus.AVAILABLE
        self.book_repo.save(book)
        member.return_book(loan.isbn)
