"""
Exercise 08: Reverse a String

There are multiple ways to reverse a string in Python.
"""

def main():
    original = "OOP Fundamentals"
    
    # Way 1: Slice notation (Most common/Pythonic)
    # syntax: [start:stop:step] - step -1 reverses the sequence
    way1 = original[::-1]
    
    # Way 2: Join and reversed iterator
    # reversed() returns an iterator, .join() combines it into a string
    way2 = "".join(reversed(original))
    
    print(f"Original: {original}")
    print(f"Reversed (Way 1): {way1}")
    print(f"Reversed (Way 2): {way2}")

if __name__ == "__main__":
    main()
