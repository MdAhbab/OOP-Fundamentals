"""
Exercise 01: Leap Year Checker

ALGORITHM:
1. Divide by 4: If yes, it's a leap year candidate.
2. Divide by 100: If yes, it's NOT a leap year UNLESS:
3. Divide by 400: If yes, it's definitely a leap year.
"""

def is_leap_year(year):
    # Pythonic logic using boolean operators
    # A year is a leap year if (divisible by 4 AND not by 100) OR (divisible by 400)
    return (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

def main():
    try:
        # Get input and convert to integer
        user_input = input("Enter a year: ").strip()
        if not user_input:
            print("Please enter a value.")
            return
            
        year = int(user_input)
        
        if is_leap_year(year):
            print(f"✅ {year} is a leap year.")
        else:
            print(f"❌ {year} is NOT a leap year.")
            
    except ValueError:
        print("⚠️ Error: Please enter a valid numeric year.")

if __name__ == "__main__":
    main()
