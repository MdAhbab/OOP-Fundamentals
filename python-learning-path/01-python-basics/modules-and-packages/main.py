"""
Modules and Packages Demo
Covers importing modules, packages, and sys.path.
"""

import sys
import os

# To import from the utils package, we can use absolute or relative imports.
# In a standard script, we use absolute imports.
from utils.math_helper import add
import utils.math_helper as mh

def main():
    print(f"Current Working Directory: {os.getcwd()}")
    
    # 1. Using imported functions
    result_add = add(10, 5)
    result_mul = mh.multiply(10, 5)
    
    print(f"10 + 5 = {result_add}")
    print(f"10 * 5 = {result_mul}")
    
    # 2. Inspecting the system path
    print(f"Python Version: {sys.version.split()[0]}")
    # print(f"Sys Path: {sys.path[:3]}...") # Shows where Python looks for modules

if __name__ == "__main__":
    main()
