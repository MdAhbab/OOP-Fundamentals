"""
File I/O Demo
Covers reading/writing files using context managers and pathlib.
"""

import os
from pathlib import Path

def main():
    # 1. Pathlib (Modern path handling)
    data_dir = Path("data")
    data_dir.mkdir(exist_ok=True)
    file_path = data_dir / "sample.txt"
    
    # 2. Writing to a file (Context manager 'with' handles closing)
    with open(file_path, "w") as f:
        f.write("Hello, Python File I/O!\n")
        f.write("Line 2: Context managers are awesome.\n")
        
    print(f"File written to: {file_path}")
    
    # 3. Reading from a file
    print("\nReading file contents:")
    with open(file_path, "r") as f:
        # Read line by line
        for line in f:
            print(f"  Line: {line.strip()}")
            
    # 4. Appending to a file
    with open(file_path, "a") as f:
        f.write("Line 3: This line was appended.\n")
        
    # 5. Quick read (Convenience)
    content = file_path.read_text()
    print(f"\nFull file content:\n{content}")
    
    # Cleanup (Optional)
    # file_path.unlink()
    # data_dir.rmdir()

if __name__ == "__main__":
    main()
