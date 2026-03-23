"""
Member Model Module

Defines the Member dataclass and MembershipType enum for representing
library members with different borrowing limits based on membership tier.
"""
from dataclasses import dataclass, field
from enum import Enum


class MembershipType(Enum):
    """
    Membership tiers with their borrowing limits.
    The value represents max books a member can borrow.
    """
    BASIC = 3
    PREMIUM = 10


@dataclass
class Member:
    """
    Represents a library member.

    Attributes:
        member_id: Unique identifier for the member
        name: Member's name
        membership_type: Tier of membership (affects borrowing limit)
        borrowed_books: List of ISBNs currently borrowed
    """
    member_id: str
    name: str
    membership_type: MembershipType = MembershipType.BASIC
    # Default factory for mutable list to avoid shared state
    borrowed_books: list[str] = field(default_factory=list)

    @property
    def max_books(self) -> int:
        """Returns maximum books this member can borrow based on tier."""
        return self.membership_type.value

    def can_borrow_more(self) -> bool:
        """Check if member hasn't reached their borrowing limit."""
        return len(self.borrowed_books) < self.max_books

    def borrow_book(self, isbn: str):
        """Add book to borrowed list. Raises ValueError if limit reached."""
        if self.can_borrow_more():
            self.borrowed_books.append(isbn)
        else:
            raise ValueError(f"Member {self.name} has reached borrowing limit.")

    def return_book(self, isbn: str):
        """Remove book from borrowed list if present."""
        if isbn in self.borrowed_books:
            self.borrowed_books.remove(isbn)
