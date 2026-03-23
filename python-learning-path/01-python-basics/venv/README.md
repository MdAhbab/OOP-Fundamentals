# Virtual Environments (venv)

In Python, a virtual environment is a self-contained directory tree that contains a Python installation for a particular version of Python, plus a number of additional packages.

## Why use them?
1. **Isolation**: Avoid conflicts between libraries across projects (e.g., Project A needs Django 3.2, Project B needs Django 4.0).
2. **Reproducibility**: `pip freeze > requirements.txt` allows others to recreate your exact environment.
3. **Cleanliness**: Your base system Python stays clean.

## Usage

### 1. Creation
```bash
python -m venv .venv
```

### 2. Activation
- **Windows**: `.venv\Scripts\activate`
- **Mac/Linux**: `source .venv/bin/activate`

### 3. Deactivation
```bash
deactivate
```

### 4. Installing Dependencies
```bash
pip install -r requirements.txt
```
