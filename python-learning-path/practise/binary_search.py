"""
Exercise 17: Binary Search

ALGORITHM:
Requires a sorted list. 
Repeatedly divide the search interval in half to find the target.
Time Complexity: O(log n)
"""

def binary_search(arr, target):
    low = 0
    high = len(arr) - 1
    
    # Continue searching while the sub-range is valid
    while low <= high:
        # Find the middle point
        mid = (high + low) // 2
        
        # Scenario 1: Target is exactly at middle
        if arr[mid] == target:
            return mid
        
        # Scenario 2: Target is in the right half
        elif arr[mid] < target:
            low = mid + 1
            
        # Scenario 3: Target is in the left half
        else:
            high = mid - 1
            
    # If we reach here, the target was not in the list
    return -1

def main():
    # MUST BE SORTED for Binary Search to work
    numbers = [2, 3, 4, 10, 40]
    target = 10
    
    result = binary_search(numbers, target)
    
    if result != -1:
        print(f"Found {target} at index {result}")
    else:
        print(f"Target {target} not found.")

if __name__ == "__main__":
    main()
