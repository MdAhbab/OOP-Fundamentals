"""
Exercise 11: Bubble Sort

ALGORITHM:
Iteratively compare adjacent elements and swap them if they are in the wrong order. 
With each full pass, the largest remaining element "bubbles" to the correct position.
"""

def bubble_sort(arr):
    n = len(arr)
    
    # Outer loop: controls the number of passes
    for i in range(n):
        # Optimization flag: if no swaps occur, the list is already sorted
        swapped = False
        
        # Inner loop: compares adjacent items
        # range(n - i - 1) because the last 'i' elements are already in place
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                # Swap elements
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        
        # If no two elements were swapped by inner loop, then break
        if not swapped:
            break

def main():
    arr = [64, 34, 25, 12, 22, 11, 90]
    print(f"Unsorted List: {arr}")
    
    bubble_sort(arr)
    
    print(f"Sorted List:   {arr}")

if __name__ == "__main__":
    main()
