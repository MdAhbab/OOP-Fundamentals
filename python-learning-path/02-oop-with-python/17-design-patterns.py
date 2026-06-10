"""
Design Patterns Demo
Covers Singleton and Strategy patterns in Python.
"""

# 1. Singleton (Using __new__)
class Database:
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            print("DEBUG: Establishing database connection...")
            cls._instance = super(Database, cls).__new__(cls)
        return cls._instance

# 2. Strategy Pattern
from abc import ABC, abstractmethod

class PaymentStrategy(ABC):
    @abstractmethod
    def pay(self, amount): pass

class CreditCardPayment(PaymentStrategy):
    def pay(self, amount): print(f"Paid ${amount} via Credit Card.")

class PayPalPayment(PaymentStrategy):
    def pay(self, amount): print(f"Paid ${amount} via PayPal.")

class ShoppingCart:
    def __init__(self, payment_strategy: PaymentStrategy):
        self.strategy = payment_strategy
    def checkout(self, amount):
        self.strategy.pay(amount)

def main():
    # Singleton
    db1 = Database()
    db2 = Database()
    print(f"Database objects match? {db1 is db2}")
    
    # Strategy
    cart = ShoppingCart(PayPalPayment())
    cart.checkout(100)
    
    cart.strategy = CreditCardPayment()
    cart.checkout(200)

if __name__ == "__main__":
    main()
