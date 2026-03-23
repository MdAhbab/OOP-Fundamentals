"""
Loan Model Module

Defines the Loan dataclass and LoanStatus enum for tracking
book borrowing transactions in the library management system.
"""
from dataclasses import dataclass, field
from datetime import datetime, timedelta
from enum import Enum, auto

class LoanStatus(Enum):
    ACTIVE = auto()
    RETURNED = auto()
    OVERDUE = auto()

@dataclass
class Loan:
    """Represents a book borrowing transaction."""
    loan_id: str
    member_id: str
    isbn: str
    # Default: current time when loan is created
    borrow_date: datetime = field(default_factory=datetime.now)
    # Default: 14 days from borrow date (standard loan period)
    due_date: datetime = field(default_factory=lambda: datetime.now() + timedelta(days=14))
    return_date: datetime | None = None
    status: LoanStatus = LoanStatus.ACTIVE

    def is_overdue(self) -> bool:
        """Check if loan is overdue: must be ACTIVE and past due date."""
        return self.status == LoanStatus.ACTIVE and datetime.now() > self.due_date
