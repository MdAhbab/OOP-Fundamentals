# 🚀 OOP Fundamentals Learning Path

Welcome to the **OOP Fundamentals** repository! This project serves as a comprehensive, hands-on learning path for understanding Object-Oriented Programming (OOP) concepts, language fundamentals, and algorithm practice, implemented in both **Java** and **Python**.

Whether you are starting with basic syntax or moving on to advanced design patterns and large-scale projects, this repository has you covered.

## 📁 Repository Structure

The repository is divided into two primary learning paths, each containing parallel curricula for both languages:

- ☕ [**Java Learning Path**](./java-learning-path/) - Maven-based Java projects and exercises.
- 🐍 [**Python Learning Path**](./python-learning-path/) - Python modules, scripts, and `unittest` suites.

### Inside Each Path

Both language paths follow a similar 4-part structure:

1. **`01-*` (Basics)** 
   Covers the core language fundamentals: variables, control flow, loops, methods/functions, and basic data structures.
2. **`02-oop-*` (OOP)**
   Deep dive into Object-Oriented Programming: classes, objects, inheritance, polymorphism, encapsulation, abstraction, and SOLID principles.
3. **`03-large-projects/`**
   Practical application of OOP concepts through mini-projects (e.g., an e-commerce cart, library management system).
4. **`practise/`**
   A collection of classic computer science algorithms (searching, sorting, patterns, math problems) to sharpen problem-solving skills.

## 🛠️ Building & Testing

We provide centralized scripts to quickly compile, build, and test all modules in their respective languages.

### Java
Navigate to the `java-learning-path` directory and run the PowerShell script:
```powershell
./build-all.ps1
```
This script will:
- Iterate through all Maven projects in `01-java-basics`, `02-oop-with-java`, and `03-large-projects`, running `mvn clean test`.
- Compile all standalone Java practice algorithms in the `practise/` folder.

### Python
Navigate to the `python-learning-path` directory and run the Python script:
```bash
python test-all.py
```
This script will:
- Discover and execute all `unittest` suites (files starting with `test_*.py`) across the learning path.
- Automatically execute all standalone Python practice algorithms in the `practise/` folder to ensure they run successfully without errors.

## 🌟 Happy Learning!

Dive into your language of choice and start mastering Object-Oriented Programming and algorithmic problem solving today!
