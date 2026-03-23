"""
Inheritance Demo
Covers single inheritance, super(), and method overriding.
"""

class Animal:
    """Base class demonstrating inheritance."""
    
    def __init__(self, name: str):
        self.name = name
        print(f"DEBUG: Animal '{self.name}' initialized.")
        
    def speak(self):
        """Generic method to be overridden by subclasses."""
        print(f"{self.name} makes a sound.")
        
    def sleep(self):
        print(f"{self.name} is sleeping...")

# Subclassing (Dog inherits from Animal)
class Dog(Animal):
    """Dog subclass extending Animal."""
    
    def __init__(self, name: str, breed: str):
        # 1. Call the parent constructor using super()
        super().__init__(name)
        self.breed = breed
        print(f"DEBUG: Dog '{self.name}' of breed '{self.breed}' initialized.")
        
    # 2. Method Overriding
    def speak(self):
        print(f"{self.name} says Woof!")
        
    def fetch(self):
        """Method unique to the Dog class."""
        print(f"{self.name} is fetching the ball!")

def main():
    # 3. Object instantiation
    my_dog = Dog("Buddy", "Golden Retriever")
    
    # 4. Accessing inherited and overridden methods
    my_dog.sleep()  # Inherited from Animal
    my_dog.speak()  # Overridden in Dog
    my_dog.fetch()  # Specific to Dog

if __name__ == "__main__":
    main()
