"""
SOLID Principles Demo
Covers the five principles of object-oriented design in Python.
"""

from abc import ABC, abstractmethod
from typing import Protocol

# 1. SRP: Single Responsibility Principle
class Report:
    def __init__(self, content: str):
        self.content = content
    def get_content(self): return self.content

class ReportSaver: # Separate class for persistence
    def save_to_file(self, report: Report, filename: str):
        with open(filename, "w") as f: f.write(report.get_content())

# 2. OCP: Open/Closed Principle
class Shape(ABC):
    @abstractmethod
    def area(self): pass

class Circle(Shape):
    def __init__(self, radius): self.radius = radius
    def area(self): return 3.14 * self.radius ** 2

class AreaCalculator: # Open for new shapes, closed for modification
    def calculate(self, shapes: list[Shape]):
        return sum(s.area() for s in shapes)

# 3. LSP: Liskov Substitution Principle
# (Omitted here for brevity, but covered in comments: Subclasses should be swappable)

# 4. ISP: Interface Segregation Principle
class Printer(Protocol):
    def print_doc(self): ...
class Scanner(Protocol):
    def scan_doc(self): ...
# Better to have small specific interfaces than one giant 'AllInOneDevice' interface.

# 5. DIP: Dependency Inversion Principle
class Logger(ABC):
    @abstractmethod
    def log(self, message): pass

class FileLogger(Logger):
    def log(self, message): print(f"Saving to file: {message}")

class App: # Depends on abstraction (Logger), not implementation (FileLogger)
    def __init__(self, logger: Logger):
        self.logger = logger
    def run(self):
        self.logger.log("App started")

def main():
    print("SOLID Principles are best demonstrated by code structure.")
    # Example call for DIP
    app = App(FileLogger())
    app.run()

if __name__ == "__main__":
    main()
