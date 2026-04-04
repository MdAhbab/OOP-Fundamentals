"""
Control Flow Demo
Covers if-elif-else, loops, and match-case.
"""

def main():
    # 1. Conditionals
    score = 85
    if score >= 90:
        grade = "A"
    elif score >= 80:
        grade = "B"
    else:
        grade = "C"
    print(f"Grade: {grade}")
    
    # 2. Loops (For)
    print("For loop over range:")
    for i in range(3):
        print(f"  Count: {i}")
        
    print("For loop over list:")
    items = ["Apples", "Bananas", "Cherries"]
    for item in items:
        print(f"  Item: {item}")
        
    # 3. Loops (While)
    count = 3
    print("While loop:")
    while count > 0:
        print(f"  Countdown: {count}")
        count -= 1
        
    # 4. Structural Pattern Matching (Python 3.10+)
    command = "start"
    print("Match case:")
    match command:
        case "start":
            print("  System starting...")
        case "stop":
            print("  System stopping...")
        case _:
            print("  Unknown command")

if __name__ == "__main__":
    main()
