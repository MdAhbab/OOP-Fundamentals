"""
Debugging and Logging Demo
Covers the logging module and basic debugging concepts.
"""

import logging

# 1. Configure Logging
# Levels: DEBUG, INFO, WARNING, ERROR, CRITICAL
logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger("PythonPath")

def divide(a, b):
    logger.debug(f"Dividing {a} by {b}")
    try:
        result = a / b
        logger.info(f"Successfully divided. Result: {result}")
        return result
    except ZeroDivisionError:
        logger.error("Attempted to divide by zero!")
        return None

def main():
    print("Check the console for log output:")
    divide(10, 2)
    divide(10, 0)
    
    # 2. Debugging Concept
    # To debug at a specific point, you can use:
    # breakpoint() # Traditional: import pdb; pdb.set_trace()
    print("\nTip: Use 'breakpoint()' in Python 3.7+ to start the debugger.")

if __name__ == "__main__":
    main()
