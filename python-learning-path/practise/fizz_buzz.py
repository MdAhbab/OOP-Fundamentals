"""
Exercise 10: FizzBuzz

A staple programming challenge to test basic control flow.
"""

def main():
    # Loop from 1 to 50
    for i in range(1, 51):
        
        # Rule: Multiples of both 3 and 5 -> FizzBuzz
        # Check this specific condition FIRST.
        if i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
            
        # Rule: Multiples of 3 only -> Fizz
        elif i % 3 == 0:
            print("Fizz")
            
        # Rule: Multiples of 5 only -> Buzz
        elif i % 5 == 0:
            print("Buzz")
            
        # Otherwise, just print the number
        else:
            print(i)

if __name__ == "__main__":
    main()
