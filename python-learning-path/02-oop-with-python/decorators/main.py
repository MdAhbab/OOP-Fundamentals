"""
Decorators Demo
Covers function and class decorators.
"""

import functools

# 1. Function Decorator
def log_execution(func):
    """Decorator that logs function calls."""
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        print(f"LOG: Calling {func.__name__} with args={args}")
        result = func(*args, **kwargs)
        print(f"LOG: Finished {func.__name__}. Result={result}")
        return result
    return wrapper

@log_execution
def add(a, b):
    return a + b

# 2. Class Decorator
def singleton(cls):
    """Decorator that turns a class into a singleton."""
    instances = {}
    @functools.wraps(cls)
    def wrapper(*args, **kwargs):
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]
    return wrapper

@singleton
class AppConfig:
    def __init__(self):
        print("Config Initialized.")
        self.theme = "Dark"

def main():
    # Calling decorated function
    add(10, 20)
    
    # Using decorated class
    conf1 = AppConfig()
    conf2 = AppConfig()
    print(f"Configs match? {conf1 is conf2}")

if __name__ == "__main__":
    main()
