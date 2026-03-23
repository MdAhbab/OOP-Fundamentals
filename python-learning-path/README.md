# Python Learning Path - From Basics to OOP Excellence

Welcome to the Python Learning Path! This repository is designed to take you from a Python beginner to an advanced Object-Oriented Programming (OOP) developer. Every topic includes clear explanations, hands-on examples, and comprehensive unit tests.

## 🚀 Repository Structure

The curriculum is divided into three main phases:

### 1️⃣ Python Basics (19 Topics)
Master the foundation of Python programming, from syntax to advanced standard library features.

| # | Topic | Key Concepts |
|---|---|---|
| 01 | [Basic Syntax](01-python-basics/basic-syntax) | Indentation, comments, type system, naming |
| 02 | [Setup & Tooling](01-python-basics/setup-and-tooling) | Virtualenvs, pip, interpreters, IDEs |
| 03 | [Variables & Data Types](01-python-basics/variables-and-data-types) | Dynamic typing, int, float, str, bool |
| 04 | [Operators & Expressions](01-python-basics/operators-and-expressions) | Arithmetic, logical, comparison, identity |
| 05 | [Control Flow](01-python-basics/control-flow) | If-else, for/while loops, match-case |
| 06 | [Functions & Arguments](01-python-basics/functions-and-arguments) | Def, *args, **kwargs, lambda, scope |
| 07 | [Lists & Sequences](01-python-basics/lists-and-sequences) | Indexing, slicing, list methods, tuples |
| 08 | [String Manipulation](01-python-basics/strings) | F-strings, methods, formatting, regex |
| 09 | [Modules & Packages](01-python-basics/modules-and-packages) | Import, __init__.py, relative imports |
| 10 | [Exceptions](01-python-basics/exceptions) | Try-except-finally, custom errors |
| 11 | [Dictionaries & Sets](01-python-basics/dictionaries-and-sets) | Key-value mapping, set operations |
| 12 | [Comprehensions & Iterators](01-python-basics/comprehensions-and-iterators) | List/Dict comprehensions, iter/next |
| 13 | [Dates & Time](01-python-basics/dates-and-time) | datetime module, timezones, formatting |
| 14 | [File I/O](01-python-basics/file-io) | open(), context managers, pathlib |
| 15 | [Concurrency Basics](01-python-basics/concurrency-basics) | threading, multiprocessing, asyncio |
| 16 | [Debugging & Logging](01-python-basics/debugging-and-logging) | logging module, pdb, breakpoints |
| 17 | [Unit Testing](01-python-basics/unit-testing) | unittest, pytest basics |
| 18 | [Virtual Environments](01-python-basics/venv) | venv module, requirements.txt |
| 19 | [Type Hinting](01-python-basics/type-hinting) | typing module, MyPy, generics |

---

### 2️⃣ OOP with Python (17 Topics)
Deep dive into Object-Oriented design and Pythonic implementation patterns.

| # | Topic | Key Concepts |
|---|---|---|
| 01 | [Classes & Objects](02-oop-with-python/classes-and-objects) | __init__, self, instance variables |
| 02 | [Encapsulation](02-oop-with-python/encapsulation) | Private (_ and __) members, name mangling |
| 03 | [Inheritance](02-oop-with-python/inheritance) | Super(), multiple inheritance, MRO |
| 04 | [Polymorphism](02-oop-with-python/polymorphism) | Duck typing, method overriding |
| 05 | [Abstraction & ABCs](02-oop-with-python/abstract-base-classes) | abc module, @abstractmethod |
| 06 | [Interfaces & Protocols](02-oop-with-python/interfaces-protocols) | typing.Protocol, structural subtyping |
| 07 | [Properties & Decorators](02-oop-with-python/property-decorators) | @property, setters, deleters |
| 08 | [Dunder Methods](02-oop-with-python/dunder-methods) | __str__, __repr__, __eq__, magic methods |
| 09 | [Class & Static Methods](02-oop-with-python/class-and-static-methods) | @classmethod, @staticmethod |
| 10 | [Nested Classes](02-oop-with-python/nested-classes) | Inner classes and their usage |
| 11 | [Composition](02-oop-with-python/composition) | Has-a relationship vs Is-a |
| 12 | [Enumerations](02-oop-with-python/enums) | enum module, Auto, Flag |
| 13 | [Immutability](02-oop-with-python/immutability) | frozen dataclasses, NamedTuple |
| 14 | [SOLID Principles](02-oop-with-python/solid-principles) | Clean code principles in Python |
| 15 | [Design Patterns](02-oop-with-python/design-patterns) | Singleton, Strategy, Observer etc. |
| 16 | [Metaclasses](02-oop-with-python/metaclasses) | Class creation logic, type() |
| 17 | [Decorators](02-oop-with-python/decorators) | Function and Class decorators |

---

### 3️⃣ Practice Exercises
Common algorithmic and logic challenges for beginners.
- [Practice Exercises](./practise) (10 Challenges)

### 4️⃣ Large Projects
Real-world applications demonstrating advanced OOP design patterns.

#### 🏛️ [Library Management System](03-large-projects/library-management)
A Pythonic library management application using properties, dataclasses, and JSON persistence.

#### 🛒 [E-commerce Shopping Cart](03-large-projects/ecommerce-cart)
A feature-rich shopping cart system showing off the Strategy and Observer patterns.

## 🚀 Quick Start

### Prerequisites
- **Python 3.10+** ([Download](https://www.python.org/downloads/))
- **Pip** (usually included with Python)

### Running a Topic Example
Navigate to any topic directory and run:
```bash
python 01-python-basics/variables-and-data-types/main.py
```

### Running Tests
We use `pytest` for all modules.
```bash
pip install pytest
pytest
```

## 🛠️ Test All Modules
To verify the entire repository:
```bash
python test-all.py
```
