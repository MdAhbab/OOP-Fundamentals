"""
Interfaces and Protocols Demo
Covers static duck typing using typing.Protocol (Python 3.8+).
"""

from typing import Protocol, runtime_checkable

@runtime_checkable
class Drawable(Protocol):
    """A protocol defining the interface for something that can be drawn."""
    
    def draw(self) -> None:
        ...

class Circle:
    def draw(self) -> None:
        print("Drawing a circle.")

class Square:
    def draw(self) -> None:
        print("Drawing a square.")

class Car:
    def move(self):
        print("Car is moving.")

def render_scene(items: list[Drawable]):
    """Polymorphicly renders any item that satisfies the Drawable protocol."""
    for item in items:
        item.draw()

def main():
    # 1. Circle and Square satisfy the protocol (they have a draw() method)
    scene = [Circle(), Square()]
    render_scene(scene)
    
    # 2. Check at runtime using isinstance (requires @runtime_checkable)
    print(f"Is Circle a Drawable? {isinstance(Circle(), Drawable)}")
    print(f"Is Car a Drawable? {isinstance(Car(), Drawable)}")

if __name__ == "__main__":
    main()
