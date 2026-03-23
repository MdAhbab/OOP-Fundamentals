"""
Product Model Module

Defines an immutable Product dataclass representing items
that can be added to a shopping cart.
"""
from dataclasses import dataclass


@dataclass(frozen=True)
class Product:
    """
    Represents a product in the e-commerce system.

    Frozen dataclass ensures products are immutable (hashable)
    and can be used as dictionary keys.

    Attributes:
        id: Unique product identifier
        name: Product display name
        price: Unit price in dollars
        category: Product category for grouping
    """
    id: int
    name: str
    price: float
    category: str

    def __str__(self):
        return f"{self.name} (${self.price})"
