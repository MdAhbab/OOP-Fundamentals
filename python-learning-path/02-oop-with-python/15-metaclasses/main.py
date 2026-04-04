"""
Metaclasses Demo
Covers class creation logic and the 'type' base metaclass.
"""

# A metaclass is a class that creates other classes.
# Inherit from 'type' to create a metaclass.

class TraceMeta(type):
    """Metaclass that traces the attributes of the class it creates."""
    def __new__(cls, name, bases, dct):
        print(f"DEBUG: Creating class '{name}' using TraceMeta.")
        print(f"DEBUG: Attributes found: {list(dct.keys())}")
        
        # Enforce rule: All my class attributes must be lowercase
        lowercase_dct = {}
        for key, value in dct.items():
            if not key.startswith("__"):
                lowercase_dct[key.lower()] = value
            else:
                lowercase_dct[key] = value
                
        return super().__new__(cls, name, bases, lowercase_dct)

class MyClass(metaclass=TraceMeta):
    UPPER_VAR = "I will be lowercased"
    def MY_METHOD(self):
        print("I am a method.")

def main():
    obj = MyClass()
    # Check if the attribute was lowercased by the metaclass
    print(f"Accessing 'upper_var': {obj.upper_var}") # type: ignore
    try:
        print(obj.UPPER_VAR) # type: ignore
    except AttributeError:
        print("UPPER_VAR no longer exists due to metaclass interception!")

if __name__ == "__main__":
    main()
