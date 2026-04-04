"""
Exceptions Demo
Covers try-except-finally blocks and custom exceptions.
"""

class InsufficientBalanceError(Exception):
    """Custom exception for banking scenarios."""
    pass

def withdraw(balance, amount):
    if amount > balance:
        raise InsufficientBalanceError(f"Cannot withdraw {amount} from {balance}")
    return balance - amount

def main():
    # 1. Standard Exception Handling
    try:
        num = int(input("Enter a number to divide 100 by: ") or "0")
        result = 100 / num
        print(f"Result: {result}")
    except ZeroDivisionError:
        print("Error: You cannot divide by zero!")
    except ValueError:
        print("Error: Please enter a valid integer.")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
    finally:
        print("Division attempt finished.")

    # 2. Custom Exceptions
    print("\nCustom Exception Demo:")
    try:
        withdraw(50, 100)
    except InsufficientBalanceError as e:
        print(f"Caught custom error: {e}")

if __name__ == "__main__":
    main()
