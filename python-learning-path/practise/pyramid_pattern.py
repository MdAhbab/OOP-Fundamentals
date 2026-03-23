"""
Exercise 07: Pyramid Pattern

LOGIC:
For a pyramid of height H:
Row i (1-indexed) has:
- (H - i) spaces
- (2*i - 1) stars
"""

def main():
    height = 5
    
    for i in range(1, height + 1):
        # 1. Calculate spaces needed for alignment
        spaces = " " * (height - i)
        
        # 2. Calculate stars (odd number progression: 1, 3, 5...)
        stars = "*" * (2 * i - 1)
        
        # 3. Combine and print
        print(f"{spaces}{stars}")

if __name__ == "__main__":
    main()
