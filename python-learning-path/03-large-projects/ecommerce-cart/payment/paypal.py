"""
PayPal Payment Module

Implements the PaymentStrategy interface for processing
PayPal payments in the e-commerce system.
"""
from .strategy import PaymentStrategy


class PayPalPayment(PaymentStrategy):
    """
    PayPal payment strategy implementation.

    Processes payments using PayPal account email.
    In production, this would integrate with PayPal API.
    """

    def __init__(self, email: str):
        self._email = email

    def process_payment(self, amount: float) -> bool:
        """Process payment via PayPal API (simulated)."""
        print(f"Processing PayPal payment of ${amount:.2f} for {self._email}...")
        return True

    def get_method_name(self) -> str:
        return "PayPal"
