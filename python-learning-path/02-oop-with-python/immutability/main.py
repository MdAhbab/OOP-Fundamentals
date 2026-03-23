"""
Immutability Demo
Covers frozen dataclasses and NamedTuples for immutable state.
"""

from dataclasses import dataclass
from typing import NamedTuple

# 1. Frozen Dataclass (Modern and Preferred)
@dataclass(frozen=True)
class UserConfig:
    api_key: str
    timeout: int
    retries: int = 3

# 2. NamedTuple (Traditional and Lightweight)
class Point(NamedTuple):
    x: float
    y: float

def main():
    # 1. Dataclass Immutability
    config = UserConfig("SECRET_KEY_123", 30)
    print(f"Config: {config}")
    
    try:
        config.timeout = 60 # type: ignore
    except Exception as e:
        print(f"Caught error (Dataclass): {e}")
        
    # 2. NamedTuple Immutability
    p = Point(10.5, 20.0)
    print(f"Point: {p}")
    
    try:
        p.x = 15.0 # type: ignore
    except AttributeError as e:
        print(f"Caught error (NamedTuple): {e}")

if __name__ == "__main__":
    main()
