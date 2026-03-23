"""
Exercise 02: Fibonacci Sequence

CONCEPT:
Each number is the sum of the two preceding ones.
Sequence: 0, 1, 1, 2, 3, 5, 8, ...
"""

def generate_fibonacci(n):
    if n <= 0: return []
    if n == 1: return [0]
    
    # Initialize list with first two terms
    fib = [0, 1]
    
    # Loop to generate terms from index 2 to n-1
    for i in range(2, n):
        # Add the sum of the last two elements
        next_val = fib[-1] + fib[-2]
        fib.append(next_val)
        
    return fib

def main():
    try:
        n = int(input("How many Fibonacci terms to generate? ") or "0")
        
        result = generate_fibonacci(n)
        
        # Format the list into a string for pretty printing
        print(f"Sequence: {', '.join(map(str, result))}")
        
    except ValueError:
        print("Invalid input. Please enter an integer.")

if __name__ == "__main__":
    main()
