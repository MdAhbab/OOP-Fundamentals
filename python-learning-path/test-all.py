"""
Global test runner for the Python Learning Path.
Discovers and runs all unit tests in the repository.
"""

import unittest
import os
import sys

def run_all_tests():
    print("--- Python Learning Path: Global Test Suite ---")
    loader = unittest.TestLoader()
    # Discover all tests starting with 'test_' in the current directory
    suite = loader.discover(start_dir=".", pattern="test_*.py")
    
    runner = unittest.TextTestRunner(verbosity=2)
    result = runner.run(suite)
    
    if result.wasSuccessful():
        print("\n✅ All tests passed!")
        sys.exit(0)
    else:
        print("\n❌ Some tests failed.")
        sys.exit(1)

if __name__ == "__main__":
    run_all_tests()
