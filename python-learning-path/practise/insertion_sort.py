"""
Exercise 13: Insertion Sort

ALGORITHM:
Pick an element from the unsorted part and insert it into its correct 
relative position in the sorted part.
"""

def insertion_sort(arr):
    # Traverse from index 1 (second element) to the end
    for i in range(1, len(arr)):
        key = arr[i] # The element to be inserted
        
        # Move elements of arr[0..i-1] that are greater than 'key'
        # to one position ahead of their current position
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        
        # Insert the key at its correct position
        arr[j + 1] = key

def main():
    arr = [12, 11, 13, 5, 6]
    print(f"Original: {arr}")
    
    insertion_sort(arr)
    
    print(f"Sorted:   {arr}")

if __name__ == "__main__":
    main()
