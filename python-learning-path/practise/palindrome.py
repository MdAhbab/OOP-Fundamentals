"""
Exercise 04: Palindrome Checker

PYTHONIC TIP:
Python strings can be easily reversed using slice notation [::-1].
"""

def main():
    # Strip whitespace and convert to lower case for accurate comparison
    text = input("Enter text: ").strip().lower()
    
    if not text:
        print("Empty string provided.")
        return

    # reversed_text = original_text[::-1] 
    # This creates a copy of the string in reverse order
    reversed_text = text[::-1]
    
    if text == reversed_text:
        print(f"✅ '{text}' is a palindrome.")
    else:
        print(f"❌ '{text}' is NOT a palindrome.")
        print(f"Reverse is: '{reversed_text}'")

if __name__ == "__main__":
    main()
