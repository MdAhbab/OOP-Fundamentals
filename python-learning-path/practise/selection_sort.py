"""
Exercise 12: Selection Sort

ALGORITHM:
Divide the list into two parts: sorted (left) and unsorted (right).
Continuously find the minimum element in the unsorted part and 
swap it with the first unsorted element.
"""

def selection_sort(arr):
    size = len(arr)
    
    # Traverse through all array elements
    for i in range(size):
        # Find the minimum element in remaining unsorted array
        min_index = i
        for j in range(i + 1, size):
            if arr[j] < arr[min_index]:
                min_index = j
        
        # Swap the found minimum element with the first element
        arr[i], arr[min_index] = arr[min_index], arr[i]

def main():
    # Test data
    numbers = [64, 25, 12, 22, 11]
    print(f"Before: {numbers}")
    
    selection_sort(numbers)
    
    print(f"After:  {numbers}")

if __name__ == "__main__":
    main()
