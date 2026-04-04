"""
Composition Demo
Covers 'has-a' relationship as an alternative to inheritance.
"""

class Engine:
    def __init__(self, horsepower: int):
        self.horsepower = horsepower
        
    def start(self):
        print(f"Engine with {self.horsepower} HP is starting...")

class Wheels:
    def __init__(self, size: int):
        self.size = size
        
    def rotate(self):
        print(f"Wheels of size {self.size} are rotating.")

class Car:
    """Demonstrates Composition: A Car HAS-AN Engine and HAS Wheels."""
    
    def __init__(self, make: str, hp: int, wheel_size: int):
        self.make = make
        # Composition: Creating instances of other classes inside the initializer
        self.engine = Engine(hp)
        self.wheels = Wheels(wheel_size)
        
    def drive(self):
        print(f"Driving my {self.make}:")
        self.engine.start()
        self.wheels.rotate()

def main():
    my_car = Car("Toyota", 150, 17)
    my_car.drive()

if __name__ == "__main__":
    main()
