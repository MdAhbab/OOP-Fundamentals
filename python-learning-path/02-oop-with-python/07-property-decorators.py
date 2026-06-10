"""
Property Decorators Demo
Covers the Pythonic way to implement getters, setters, and deleters.
"""

class Product:
    def __init__(self, name: str, price: float):
        self._name = name
        self._price = price
        
    # 1. Getter (@property)
    @property
    def price(self) -> float:
        return self._price
        
    # 2. Setter (@property_name.setter)
    @price.setter
    def price(self, value: float):
        if value < 0:
            raise ValueError("Price cannot be negative!")
        print(f"DEBUG: Setting price to ${value}")
        self._price = value
        
    # 3. Deleter (@property_name.deleter)
    @price.deleter
    def price(self):
        print("DEBUG: Deleting price attribute.")
        del self._price

def main():
    p = Product("Laptop", 999.0)
    
    # Access looks like a direct attribute access, but calls the getter
    print(f"Product: {p._name}, Price: ${p.price}")
    
    # Assignment calls the setter
    p.price = 850.0 
    
    try:
        p.price = -10
    except ValueError as e:
        print(f"Caught error: {e}")
        
    # deletion
    del p.price

if __name__ == "__main__":
    main()
