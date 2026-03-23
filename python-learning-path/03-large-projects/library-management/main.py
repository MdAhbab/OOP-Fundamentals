"""
Library Management System - Main Entry Point

Demonstrates the library management system functionality including:
- Adding books to the library
- Registering members with different membership tiers
- Borrowing and returning books
- Error handling for invalid operations
"""
from models.book import Book
from models.member import Member, MembershipType
from services.library_service import LibraryService


def main():
    service = LibraryService()

    # 1. Setup Data - Add books and register a premium member
    service.add_book(Book("978-01", "Python Design Patterns", "Alex Martelli"))
    service.add_book(Book("978-02", "Effective Python", "Brett Slatkin"))

    member = Member("M001", "ahbab", MembershipType.PREMIUM)
    service.register_member(member)

    print("--- Library Management System ---")
    print(f"Books in library: {len(service.book_repo.find_all())}")

    # 2. Borrowing - Attempt to borrow a book, then try borrowing same book
    try:
        loan_id = service.borrow_book("M001", "978-01")
        print(f"Borrowed '978-01'. Loan ID: {loan_id}")

        # Try to borrow same book (should fail - book not available)
        service.borrow_book("M001", "978-01")
    except ValueError as e:
        print(f"Expected Error: {e}")

    # 3. Returning - Return the borrowed book
    service.return_book(loan_id)
    print("Returned book. Status updated.")

    # 4. Final state check - Verify book is available again
    book = service.book_repo.find_by_isbn("978-01")
    print(f"Final Book Status: {book.status.name}")


if __name__ == "__main__":
    main()
