"""
Cart Item Model Module

Defines the CartItem class representing a product with a quantity
in the shopping cart. Handles price calculation per line item.
"""
from .product import Product


class CartItem:
    """
    Represents a line item in the shopping cart.

    Combines a product with a quantity and provides
    computed total price for the line item.

    Attributes:
        product: The product being purchased
        quantity: Number of units (default: 1)
    """

    def __init__(self, product: Product, quantity: int = 1):
        self.product = product
        self.quantity = quantity

    @property
    def total_price(self) -> float:
        """Calculate total price: unit price x quantity."""
        return self.product.price * self.quantity

    def __str__(self):
        return f"{self.product.name} x {self.quantity} = ${self.total_price:.2f}"
