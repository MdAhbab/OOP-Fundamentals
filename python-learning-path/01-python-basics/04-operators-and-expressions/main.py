"""
Operators and Expressions Demo
Covers arithmetic, comparison, logical, and identity operators.
"""

def main():
    # 1. Arithmetic Operators
    print(f"10 + 3 = {10 + 3}")
    print(f"10 / 3 = {10 / 3}")    # Float division
    print(f"10 // 3 = {10 // 3}")  # Floor division
    print(f"10 % 3 = {10 % 3}")    # Modulo
    print(f"10 ** 3 = {10 ** 3}")  # Power
    
    # 2. Comparison Operators
    print(f"10 > 3: {10 > 3}")
    print(f"10 == 10.0: {10 == 10.0}") # True (Value comparison)
    
    # 3. Logical Operators
    print(f"True and False: {True and False}")
    print(f"True or False: {True or False}")
    print(f"not True: {not True}")
    
    # 4. Identity Operators
    a = [1, 2]
    b = [1, 2]
    c = a
    print(f"a == b: {a == b}") # True (Value comparison)
    print(f"a is b: {a is b}") # False (Identity comparison)
    print(f"a is c: {a is c}") # True (Identity comparison)

if __name__ == "__main__":
    main()
