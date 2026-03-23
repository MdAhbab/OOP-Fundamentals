"""
Variables and Data Types Demo
Covers dynamic typing and primitive types.
"""

def main():
    # 1. Dynamic Typing
    # Variable types are determined at runtime
    x = 10
    print(f"x is {x}, type: {type(x)}")
    
    x = "Hello"
    print(f"x is now {x}, type: {type(x)}")
    
    # 2. Integers and Floats
    age = 25
    pi = 3.14159
    print(f"Age: {age}, Pi: {pi}")
    
    # 3. Strings
    name = 'Alice'
    quote = "Python is 'awesome'"
    multiline = """This is a
multiline string."""
    print(f"Name: {name}\nQuote: {quote}\n{multiline}")
    
    # 4. Booleans
    is_python_fun = True
    is_java_boring = False  # Depends on the person :)
    print(f"Fun? {is_python_fun}, Boring? {is_java_boring}")
    
    # 5. Type Conversions (Casting)
    num_str = "100"
    num_int = int(num_str)
    print(f"Converted {num_str} to {num_int}, type: {type(num_int)}")

if __name__ == "__main__":
    main()
