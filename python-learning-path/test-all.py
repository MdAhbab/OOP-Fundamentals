"""
Global test runner for the Python Learning Path.
Discovers and runs all unit tests in the repository.
"""

import unittest
import os
import sys
import subprocess
import glob

def run_practise_scripts():
    print("\n--- Running Python Practice Scripts ---")
    practise_dir = "practise"
    if not os.path.isdir(practise_dir):
        print(f"Directory '{practise_dir}' not found, skipping.")
        return True

    scripts = glob.glob(os.path.join(practise_dir, "*.py"))
    all_passed = True
    for script in scripts:
        print(f"Executing {script}...", end=" ")
        try:
            # Provide multiple newlines to satisfy any input() calls without hanging
            result = subprocess.run([sys.executable, script], capture_output=True, text=True, input="\n\n\n\n\n")
            if result.returncode == 0:
                print("[PASS] Success")
            else:
                print("[FAIL] Failed")
                print(f"Error output:\n{result.stderr}")
                all_passed = False
        except Exception as e:
            print("[FAIL] Error")
            print(f"Exception: {e}")
            all_passed = False

    return all_passed

def run_all_tests():
    print("--- Python Learning Path: Global Test Suite ---")
    loader = unittest.TestLoader()
    # Discover all tests starting with 'test_' in the current directory
    suite = loader.discover(start_dir=".", pattern="test_*.py")
    
    runner = unittest.TextTestRunner(verbosity=2)
    result = runner.run(suite)
    
    practise_success = run_practise_scripts()
    
    if result.wasSuccessful() and practise_success:
        print("\n[PASS] All tests and practice scripts passed!")
        sys.exit(0)
    else:
        print("\n[FAIL] Some tests or practice scripts failed.")
        sys.exit(1)

if __name__ == "__main__":
    run_all_tests()
