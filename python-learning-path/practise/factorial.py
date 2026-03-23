"""
Exercise 05: Factorial Calculation

APPROACH: Recursion
Recursion is when a function calls itself.
Base case: 0! = 1, 1! = 1
Recursive step: n! = n * (n-1)!
"""

def factorial(n):
    # 1. Base Case: stops the recursion
    if n == 0 or n == 1:
        return 1
    
    # 2. Recursive Step
    return n * factorial(n - 1)

def main():
    try:
        num = int(input("Enter a positive integer: ") or "0")
        
        if num < 0:
            print("Factorial is not defined for negative numbers.")
            return

        # Warning: Python has a recursion limit (usually 1000)
        # For very large numbers, an iterative loop is safer.
        result = factorial(num)
        print(f"Result: {num}! = {result}")
        
    except ValueError:
        print("Please enter a valid integer.")
    except RecursionError:
        print("Number too large for recursive calculation.")

if __name__ == "__main__":
    main()
