"""
String Manipulation Demo
Covers f-strings, methods, and formatting.
"""

def main():
    # 1. Formatting
    name = "Alice"
    age = 30
    
    # Modern f-strings (Preferred)
    print(f"Hello, {name}. You are {age} years old.")
    
    # 2. Common Methods
    text = "   Python is powerful!   "
    print(f"Original: '{text}'")
    print(f"Strip: '{text.strip()}'")
    print(f"Upper: {text.upper()}")
    print(f"Lower: {text.lower()}")
    print(f"Replace: {text.replace('powerful', 'amazing').strip()}")
    
    # 3. Splitting and Joining
    csv = "red,blue,green,yellow"
    colors = csv.split(",")
    print(f"Split list: {colors}")
    
    joined = " | ".join(colors)
    print(f"Joined string: {joined}")
    
    # 4. Multi-line strings
    email_template = """
    Hello {name},
    
    Welcome to the Python Learning Path!
    
    Best,
    The Team
    """
    print(email_template.format(name=name))

if __name__ == "__main__":
    main()
