"""
Exercise 03: Prime Number Checker

OPTIMIZATION:
Instead of checking all numbers up to n, we only check up to sqrt(n).
If n is divisible by any number, it's not prime.
"""

import math

def is_prime(n):
    # Prime numbers must be greater than 1
    if n <= 1:
        return False
    
    # Optimization: Loop from 2 up to the square root of n (inclusive)
    # Factors occur in pairs (e.g., for 36: 4*9, 6*6). One factor is always <= sqrt(n).
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False # Found a factor, not prime
            
    return True # No factors found, it's prime

def main():
    try:
        num = int(input("Enter a number to check: ") or "0")
        
        if is_prime(num):
            print(f"💎 {num} is a prime number.")
        else:
            print(f"⚪ {num} is NOT a prime number.")
            
    except ValueError:
        print("Invalid numeric input.")

if __name__ == "__main__":
    main()
