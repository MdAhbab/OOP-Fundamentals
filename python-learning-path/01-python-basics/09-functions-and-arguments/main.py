"""
Functions and Arguments Demo
Covers positioning, keyword, default, variable args (*args, **kwargs), and lambdas.
"""

def greet(name, message="Hello"):
    """Standard function with a default argument."""
    return f"{message}, {name}!"

def calculate_sum(*args):
    """Variable number of positional arguments (*args)."""
    return sum(args)

def print_info(**kwargs):
    """Variable number of keyword arguments (**kwargs)."""
    for key, value in kwargs.items():
        print(f"  {key}: {value}")

def main():
    # 1. Standard call
    print(greet("Alice"))
    print(greet("Bob", message="Good morning"))
    
    # 2. *args (Packing into a tuple)
    total = calculate_sum(1, 2, 3, 4, 5)
    print(f"Sum of 1..5: {total}")
    
    # 3. **kwargs (Packing into a dictionary)
    print("User Info:")
    print_info(user="ahbab", role="Admin", status="Active")
    
    # 4. Lambda functions (Anonymous functions)
    square = lambda x: x * x
    print(f"Square of 5: {square(5)}")
    
    # 5. First-class functions (Passing as arguments)
    numbers = [1, 5, 2, 8]
    sorted_nums = sorted(numbers, key=lambda x: -x)
    print(f"Sorted descending: {sorted_nums}")

if __name__ == "__main__":
    main()
