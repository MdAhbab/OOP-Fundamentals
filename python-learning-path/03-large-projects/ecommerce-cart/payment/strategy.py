"""
Payment Strategy Module

Defines the abstract PaymentStrategy base class implementing the Strategy Pattern.
This allows different payment methods (Credit Card, PayPal, etc.) to be used
interchangeably at runtime without modifying the checkout logic.
"""
from abc import ABC, abstractmethod


class PaymentStrategy(ABC):
    """
    Abstract base class for payment strategies (Strategy Pattern).

    Subclasses must implement:
    - process_payment(): Execute the actual payment transaction
    - get_method_name(): Return a human-readable payment method name

    Usage:
        payment = CreditCardPayment(card_number, cvv)
        cart.checkout(payment)  # Any PaymentStrategy works here
    """

    @abstractmethod
    def process_payment(self, amount: float) -> bool:
        """
        Process a payment for the given amount.

        Args:
            amount: The total amount to charge

        Returns:
            True if payment succeeded, False otherwise
        """
        pass

    @abstractmethod
    def get_method_name(self) -> str:
        """Return the display name of this payment method."""
        pass
