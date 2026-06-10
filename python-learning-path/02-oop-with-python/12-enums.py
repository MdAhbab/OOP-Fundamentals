"""
Enums Demo
Covers the 'enum' module for defining named constants.
"""

from enum import Enum, auto

class OrderStatus(Enum):
    """Basic Enum for order tracking."""
    PENDING = auto()
    SHIPPED = auto()
    DELIVERED = auto()
    CANCELLED = auto()

class Priority(Enum):
    """Enum with explicit values."""
    LOW = 1
    MEDIUM = 2
    HIGH = 3

def process_order(status: OrderStatus):
    match status:
        case OrderStatus.PENDING:
            print("Order is pending approval.")
        case OrderStatus.SHIPPED:
            print("Order is on the way!")
        case OrderStatus.DELIVERED:
            print("Order received.")
        case _:
            print("Order status unknown.")

def main():
    # 1. Accessing Enum members
    current_status = OrderStatus.SHIPPED
    print(f"Status Name: {current_status.name}")
    print(f"Status Value: {current_status.value}")
    
    # 2. Logic based on Enums
    process_order(current_status)
    
    # 3. Iterating over Enums
    print("\nAll Priorities:")
    for p in Priority:
        print(f"  {p.name}: {p.value}")

if __name__ == "__main__":
    main()
