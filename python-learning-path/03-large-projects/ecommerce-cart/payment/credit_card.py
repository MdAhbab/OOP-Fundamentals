"""
Credit Card Payment Module

Implements the PaymentStrategy interface for processing
credit card payments in the e-commerce system.
"""
from .strategy import PaymentStrategy


class CreditCardPayment(PaymentStrategy):
    """
    Credit card payment strategy implementation.

    Processes payments using credit card credentials.
    In production, this would integrate with a payment gateway.
    """

    def __init__(self, card_number: str, cvv: str):
        self._card_number = card_number
        self._cvv = cvv

    def process_payment(self, amount: float) -> bool:
        """Process payment via credit card gateway (simulated)."""
        print(f"Processing Credit Card payment of ${amount:.2f}...")
        # Simulating payment gateway logic
        return True

    def get_method_name(self) -> str:
        return "Credit Card"
