"""
Polymorphism Demo
Covers dynamic polymorphism and 'duck typing'.
"""

# Duck Typing: "If it walks like a duck and quacks like a duck, it's a duck."
# No explicit interface required.

class Duck:
    def speak(self):
        print("Quack!")

class Person:
    def speak(self):
        print("Hello, I'm a human!")

class Dog:
    def speak(self):
        print("Woof!")

# polymorphic function
def make_it_speak(entity):
    """Works with ANY object that has a speak() method."""
    entity.speak()

def main():
    # 1. Dynamic Polymorphism via Duck Typing
    entities = [Duck(), Person(), Dog()]
    
    print("Iterating over entities polymorphicly:")
    for e in entities:
        make_it_speak(e)
        
    # 2. Operator Overloading (Special form of polymorphism)
    # The '+' operator behaves differently for ints and strings
    print(f"\n10 + 20: {10 + 20}")
    print(f"'Python' + 'ic': {'Python' + 'ic'}")

if __name__ == "__main__":
    main()
