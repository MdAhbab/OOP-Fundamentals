"""
Comprehensions and Iterators Demo
Covers list/dict comprehensions and advanced iteration.
"""

def main():
    # 1. List Comprehension (Concise way to create lists)
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    
    # Traditional way:
    # squares = []
    # for x in numbers:
    #     squares.append(x * x)
    
    # Pythonic way:
    squares = [x * x for x in numbers if x % 2 == 0]
    print(f"Squares of even numbers: {squares}")
    
    # 2. Dictionary Comprehension
    user_names = ["Alice", "Bob", "Charlie"]
    name_lengths = {name: len(name) for name in user_names}
    print(f"Name Lengths: {name_lengths}")
    
    # 3. Generator Expressions (Memory efficient)
    # Uses () instead of [] - doesn't store the whole list in memory
    gen = (x ** 2 for x in range(1000000))
    print(f"Generator first value: {next(gen)}")
    
    # 4. Iterators (iter/next)
    print("Iterator manual check:")
    fruit_iter = iter(["Apple", "Banana"])
    print(f"  Next: {next(fruit_iter)}")
    print(f"  Next: {next(fruit_iter)}")
    # print(next(fruit_iter)) # Raises StopIteration

if __name__ == "__main__":
    main()
