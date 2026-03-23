"""
Lists and Sequences Demo
Covers lists, tuples, indexing, slicing, and methods.
"""

def main():
    # 1. Lists (Mutable sequences)
    fruits = ["Apple", "Banana", "Cherry"]
    fruits.append("Date")
    fruits[1] = "Blueberry"
    print(f"Fruits: {fruits}")
    
    # 2. Tuples (Immutable sequences)
    # Often used for fixed data structures
    coordinates = (10, 20)
    print(f"Coordinates: {coordinates}")
    # coordinates[0] = 15  # This would raise a TypeError
    
    # 3. Indexing and Slicing (Crucial concept)
    numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(f"Single index [0]: {numbers[0]}")
    print(f"Negative index [-1]: {numbers[-1]}")
    print(f"Slice [2:5]: {numbers[2:5]}")     # Index 2 to 4
    print(f"Slice [:3]: {numbers[:3]}")       # Star to 2
    print(f"Slice [7:]: {numbers[7:]}")       # 7 to end
    print(f"Step [::2]: {numbers[::2]}")     # Every second element
    print(f"Reverse [::-1]: {numbers[::-1]}") # Reversed
    
    # 4. Sequence Unpacking
    point = (3, 4)
    x, y = point
    print(f"x={x}, y={y}")

if __name__ == "__main__":
    main()
