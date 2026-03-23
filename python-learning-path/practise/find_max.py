"""
Exercise 09: Find Maximum in List

Demonstrating the manual algorithmic approach vs built-in magic.
"""

def find_max_manual(numbers):
    if not numbers: return None
    
    # Assume first element is max
    current_max = numbers[0]
    
    # Iterate through the rest and update if a larger one is found
    for num in numbers:
        if num > current_max:
            current_max = num
            
    return current_max

def main():
    data = [12, 45, 7, 23, 56, 89, 34]
    
    print(f"Data List: {data}")
    
    # Algorithmic way
    print(f"Calculated Max (Manual): {find_max_manual(data)}")
    
    # Built-in Python way (the professional way)
    print(f"Calculated Max (Built-in): {max(data)}")

if __name__ == "__main__":
    main()
