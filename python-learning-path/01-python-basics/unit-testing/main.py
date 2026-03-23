"""
Unit Testing Demo
Covers the built-in unittest framework.
"""

import unittest

# Function to test
def double(x):
    return x * 2

def subtract(a, b):
    return a - b

class TestMathOperations(unittest.TestCase):
    # Runs before every test
    def setUp(self):
        self.value = 10
        
    def test_double(self):
        self.assertEqual(double(5), 10)
        self.assertEqual(double(-1), -2)
        
    def test_subtract(self):
        self.assertEqual(subtract(10, 5), 5)
        
    def test_type_error(self):
        # Verify that certain calls raise expected errors
        # Note: double("string") doesn't raise TypeError in Python (string * 2 = "stringstring")
        # Instead, test a scenario that DOES raise TypeError: adding incompatible types
        with self.assertRaises(TypeError):
            subtract("not a number", 5)  # This raises TypeError: can't subtract int from str
            
    def test_double_string(self):
        # Actually demonstrating Python behavior
        self.assertEqual(double("A"), "AA")

if __name__ == "__main__":
    unittest.main()
