"""
Cart Service Module

Provides the main CartService class that manages shopping cart
operations. Implements the Observer pattern for event notifications
and Strategy pattern for flexible payment processing.
"""
from typing import List, Callable
from ..models.cart_item import CartItem
from ..payment.strategy import PaymentStrategy


class CartService:
    """
    Shopping cart service with observer pattern support.

    Manages cart items and provides checkout functionality
    with pluggable payment strategies. Observers are notified
    of cart events (add, checkout success/failure).
    """

    def __init__(self):
        self._items: List[CartItem] = []
        # Observer pattern: list of callback functions to notify
        self._observers: List[Callable[[str], None]] = []

    def add_observer(self, callback: Callable[[str], None]):
        """Register an observer callback to receive cart events."""
        self._observers.append(callback)

    def _notify(self, message: str):
        """Notify all registered observers with a message."""
        for observer in self._observers:
            observer(message)

    def add_product(self, product, quantity: int = 1):
        """Add a product to the cart and notify observers."""
        item = CartItem(product, quantity)
        self._items.append(item)
        self._notify(f"Added {product.name} (x{quantity}) to cart.")

    def calculate_total(self) -> float:
        """Sum all line item totals in the cart."""
        return sum(item.total_price for item in self._items)

    def checkout(self, payment_strategy: PaymentStrategy):
        """
        Process checkout with the given payment strategy.

        Displays summary, processes payment, and clears cart on success.
        """
        total = self.calculate_total()
        if total == 0:
            print("Cart is empty!")
            return

        # Display checkout summary
        print(f"--- Checkout Summary ---")
        for item in self._items:
            print(f"  {item}")
        print(f"Total Amount: ${total:.2f}")

        # Process payment and handle result
        if payment_strategy.process_payment(total):
            self._notify(f"Payment successful via {payment_strategy.get_method_name()}")
            self._items.clear()
        else:
            self._notify("Payment failed.")
