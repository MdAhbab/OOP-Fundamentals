"""
Abstract Base Classes (ABC) Demo
Covers abstraction using the built-in 'abc' module.
"""

from abc import ABC, abstractmethod

class Shape(ABC):
    """Abstract class demonstrating abstraction."""
    
    @abstractmethod
    def area(self) -> float:
        """Abstract method - MUST be implemented by subclasses."""
        pass
        
    @abstractmethod
    def perimeter(self) -> float:
        pass
        
    def describe(self):
        """Concrete method in an abstract class."""
        print(f"I am a {self.__class__.__name__}")

class Square(Shape):
    def __init__(self, side: float):
        self.side = side
        
    def area(self) -> float:
        return self.side * self.side
        
    def perimeter(self) -> float:
        return 4 * self.side

def main():
    # 1. Cannot instantiate abstract class
    try:
        s = Shape()
    except TypeError as e:
        print(f"Caught error: {e}")
        
    # 2. Successful instantiation of concrete subclass
    sq = Square(5.0)
    sq.describe()
    print(f"Area: {sq.area()}")
    print(f"Perimeter: {sq.perimeter()}")

if __name__ == "__main__":
    main()
