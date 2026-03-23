"""
Exercise 14: Merge Sort

ALGORITHM:
Divide the unsorted list into n sublists, each containing one element.
Repeatedly merge sublists to produce new sorted sublists until only one remains.
"""

def merge_sort(arr):
    # Only sort if list has more than one element
    if len(arr) > 1:
        # 1. Find the mid point and split the list
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        # 2. Recursive calls to sort the halves
        merge_sort(left_half)
        merge_sort(right_half)

        # 3. Merge phase
        i = j = k = 0
        
        # Merge until one sub-list is exhausted
        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        # Collect remaining elements from left_half (if any)
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        # Collect remaining elements from right_half (if any)
        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

def main():
    dataset = [12, 11, 13, 5, 6, 7]
    print(f"Input:  {dataset}")
    merge_sort(dataset)
    print(f"Output: {dataset}")

if __name__ == "__main__":
    main()
