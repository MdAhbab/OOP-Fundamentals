"""
E-commerce Cart System - Main Entry Point

Demonstrates the shopping cart functionality including:
- Observer pattern for logging cart events
- Strategy pattern for multiple payment methods
- Adding products and checkout flow
"""
from models.product import Product
from service.cart_service import CartService
from payment.credit_card import CreditCardPayment
from payment.paypal import PayPalPayment


def main():
    # 1. Setup Service and Observers
    cart = CartService()

    # Simple observer: logs all cart events to console
    def cart_logger(msg): print(f"[LOG] {msg}")
    cart.add_observer(cart_logger)

    # 2. Add Products to cart
    p1 = Product(1, "Smartphone", 799.0, "Electronics")
    p2 = Product(2, "Headphones", 199.0, "Electronics")

    cart.add_product(p1)
    cart.add_product(p2, 2)

    # 3. Checkout with PayPal (Strategy pattern demo)
    print("\nCheckout #1:")
    paypal = PayPalPayment("user@example.com")
    cart.checkout(paypal)

    # 4. Checkout with Credit Card (different payment strategy)
    print("\nCheckout #2:")
    cart.add_product(p1)
    cc = CreditCardPayment("1234-5678-9012-3456", "123")
    cart.checkout(cc)


if __name__ == "__main__":
    main()
