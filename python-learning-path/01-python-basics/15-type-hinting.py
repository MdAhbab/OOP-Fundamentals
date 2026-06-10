"""
Type Hinting Demo
Covers modern Python type annotations (PEP 484).
"""

from typing import List, Dict, Optional, Union

# 1. Basic Type Hints
def greet(name: str) -> str:
    return f"Hello, {name}"

# 2. Complex Types (List, Dict)
def process_scores(scores: List[int]) -> float:
    return sum(scores) / len(scores)

# 3. Optional and Union types
def find_user(user_id: int) -> Optional[Dict[str, Union[int, str]]]:
    if user_id == 1:
        return {"id": 1, "name": "ahbab"}
    return None

def main():
    # Note: Python ignores these at runtime! 
    # They are for IDES (VS Code, PyCharm) and static checkers (MyPy).
    
    msg = greet("Alice")
    print(msg)
    
    avg = process_scores([80, 90, 100])
    print(f"Average: {avg}")
    
    user = find_user(1)
    if user:
        print(f"Found user: {user['name']}")

if __name__ == "__main__":
    main()
