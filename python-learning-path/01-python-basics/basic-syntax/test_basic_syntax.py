import unittest
from io import StringIO
import sys
from main import main

class TestBasicSyntax(unittest.TestCase):
    def test_main_output(self):
        # Capture stdout
        captured_output = StringIO()
        sys.stdout = captured_output
        
        main()
        
        sys.stdout = sys.__stdout__
        output = captured_output.getvalue()
        
        self.assertIn("Hello from Python!", output)
        self.assertIn("Indentation defines code blocks", output)

if __name__ == "__main__":
    unittest.main()
