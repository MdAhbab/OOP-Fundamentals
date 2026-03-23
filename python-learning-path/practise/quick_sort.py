"""
Exercise 15: Quick Sort

ALGORITHM:
1. Select a 'pivot' element.
2. Partition the list into smaller than pivot, equal to pivot, and larger than pivot.
3. Recursively repeat for small and large sublists.
"""

def quick_sort(arr):
    # Base case: lists with 0 or 1 element are already sorted
    if len(arr) <= 1:
        return arr
    
    # 1. Select the pivot (middle element)
    pivot = arr[len(arr) // 2]
    
    # 2. Partition using list comprehensions
    # (Memory inefficient due to copies, but very readable for learners)
    left = [x for x in arr if x < pivot]    # Elements smaller than pivot
    middle = [x for x in arr if x == pivot]  # Elements equal to pivot
    right = [x for x in arr if x > pivot]   # Elements larger than pivot
    
    # 3. Recursive step: sort left and right parts and combine
    return quick_sort(left) + middle + quick_sort(right)

def main():
    arr = [10, 7, 8, 9, 1, 5]
    print(f"Unsorted: {arr}")
    
    sorted_arr = quick_sort(arr)
    
    print(f"Sorted:   {sorted_arr}")

if __name__ == "__main__":
    main()
