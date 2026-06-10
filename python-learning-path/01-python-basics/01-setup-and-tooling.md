# Setup & Tooling

To be effective in Python, you need to understand the environment.

## 1. Virtual Environments
Always use a virtual environment to isolate project dependencies.
```bash
python -m venv venv
source venv/bin/activate  # Mac/Linux
venv\Scripts\activate     # Windows
```

## 2. Package Manager (pip)
Install packages using `pip`.
```bash
pip install requests
pip freeze > requirements.txt
```

## 3. Python Interpreter
Check your version:
```bash
python --version
```
Required version for this path: **3.10+**
