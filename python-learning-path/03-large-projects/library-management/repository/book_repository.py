"""
Book Repository Module

Implements the Repository pattern for Book entities with JSON file persistence.
Handles serialization/deserialization of Book objects including Enum conversion.
"""
import json
from pathlib import Path
from typing import Optional
from ..models.book import Book, BookStatus


class BookRepository:
    """
    Repository for managing Book persistence to JSON file.

    Handles loading books from file on init and persisting changes on save.
    """

    def __init__(self, file_path: str):
        self.file_path = Path(file_path)
        self._books: dict[str, Book] = {}  # In-memory cache keyed by ISBN
        self._load_books()

    def _load_books(self):
        """Load all books from JSON file into memory cache."""
        if self.file_path.exists():
            with open(self.file_path, "r") as f:
                data = json.load(f)
                for item in data:
                    # Convert status string back to Enum (JSON stores as string)
                    item["status"] = BookStatus[item["status"]]
                    self._books[item["isbn"]] = Book(**item)

    def save(self, book: Book):
        """Save a book to cache and persist to file."""
        self._books[book.isbn] = book
        self._persist()

    def _persist(self):
        """Write all books from cache to JSON file."""
        data = []
        for book in self._books.values():
            # Convert dataclass to dict for JSON serialization
            book_dict = book.__dict__.copy()
            # Enum must be converted to string for JSON compatibility
            book_dict["status"] = book.status.name
            data.append(book_dict)

        with open(self.file_path, "w") as f:
            json.dump(data, f, indent=4)

    def find_by_isbn(self, isbn: str) -> Optional[Book]:
        """Find a book by ISBN. Returns None if not found."""
        return self._books.get(isbn)

    def find_all(self) -> list[Book]:
        """Return all books in the repository."""
        return list(self._books.values())
