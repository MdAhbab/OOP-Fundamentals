"""
Basic Syntax Demo
Covers entry point, comments, indentation, and naming conventions.
"""

def main():
    # 1. Printing and entry point
    print("Hello from Python!")
    
    # 2. Comments
    # This is a single-line comment
    """
    This is a multi-line 
    docstring/comment
    """
    
    # 3. Indentation (Standard: 4 spaces)
    if True:
        print("Indentation defines code blocks in Python.")
        print("No curly braces needed!")
        
    # 4. Semicolons are optional (rarely used)
    x = 10; y = 20
    print(f"Semicolons can separate statements: x={x}, y={y}")
    
    # 5. Naming Conventions (PEP 8)
    user_name = "Alice"  # snake_case for variables/functions
    class UserProfile:   # PascalCase for classes
        pass
    MAX_COUNT = 100      # UPPER_SNAKE_CASE for constants

if __name__ == "__main__":
    main()
