"""
Concurrency Basics Demo
Covers threading and basic asyncio.
"""

import threading
import time
import asyncio

# --- Threading Section ---
def print_numbers():
    for i in range(5):
        time.sleep(0.5)
        print(f"  Thread 1: {i}")

def print_letters():
    for letter in ['A', 'B', 'C', 'D', 'E']:
        time.sleep(0.3)
        print(f"  Thread 2: {letter}")

# --- AsyncIO Section ---
async def async_task(name, delay):
    print(f"  Async Task {name} starting...")
    await asyncio.sleep(delay)
    print(f"  Async Task {name} finished after {delay}s")

async def run_async_demo():
    print("\n2. AsyncIO Demo:")
    # Run tasks concurrently
    await asyncio.gather(
        async_task("A", 1),
        async_task("B", 0.5),
        async_task("C", 1.5)
    )

def main():
    # 1. Threading Demo
    print("1. Threading Demo:")
    t1 = threading.Thread(target=print_numbers)
    t2 = threading.Thread(target=print_letters)
    
    t1.start()
    t2.start()
    
    t1.join() # Wait for thread 1 to finish
    t2.join() # Wait for thread 2 to finish
    
    # 2. AsyncIO Demo
    asyncio.run(run_async_demo())

if __name__ == "__main__":
    main()
