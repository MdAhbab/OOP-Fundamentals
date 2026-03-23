"""
Exercise 06: Right-Angled Triangle Pattern

PYTHONIC TIP:
Strings in Python can be multiplied by an integer to repeat them.
"*" * 3 results in "***"
"""

def main():
    rows = 5
    
    # Loop from 1 to 'rows'
    for i in range(1, rows + 1):
        # Use string multiplication for a concise implementation
        print("*" * i)

if __name__ == "__main__":
    main()
