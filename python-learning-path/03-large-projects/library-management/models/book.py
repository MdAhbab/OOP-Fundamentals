"""
Book Model Module

Defines the Book dataclass and BookStatus enum for representing
books in the library management system.
"""
from dataclasses import dataclass, field
from enum import Enum, auto


class BookStatus(Enum):
    """Represents the availability status of a book."""
    AVAILABLE = auto()
    BORROWED = auto()
    RESERVED = auto()


@dataclass
class Book:
    """
    Represents a book in the library.

    Attributes:
        isbn: International Standard Book Number (unique identifier)
        title: The title of the book
        author: The author of the book
        status: Current availability status (default: AVAILABLE)
    """
    isbn: str
    title: str
    author: str
    status: BookStatus = BookStatus.AVAILABLE

    def __str__(self):
        return f"[{self.isbn}] {self.title} by {self.author} ({self.status.name})"
