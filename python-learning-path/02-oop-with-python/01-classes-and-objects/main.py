"""
Classes and Objects Demo
Covers class definition, constructor (__init__), instance variables, and methods.
"""

class Car:
    """A simple class representing a car."""
    
    # 1. Constructor (Initializes instance attributes)
    def __init__(self, make: str, model: str, year: int):
        self.make = make        # Instance attribute
        self.model = model      # Instance attribute
        self.year = year        # Instance attribute
        self.is_running = False # State attribute
        
    # 2. Instance Methods
    def start_engine(self):
        if not self.is_running:
            self.is_running = True
            print(f"The {self.year} {self.make} {self.model} engine is now running.")
        else:
            print("Engine is already running.")
            
    def stop_engine(self):
        self.is_running = False
        print("Engine stopped.")
        
    def get_info(self) -> str:
        return f"{self.year} {self.make} {self.model}"

def main():
    # 3. Object Creation (Instantiation)
    my_car = Car("Tesla", "Model 3", 2023)
    
    # 4. Accessing attributes and methods
    print(f"I own a {my_car.get_info()}")
    my_car.start_engine()
    my_car.stop_engine()

if __name__ == "__main__":
    main()
