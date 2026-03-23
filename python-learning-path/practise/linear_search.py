"""
Exercise 16: Linear Search

ALGORITHM:
Sequentially check each element of the list until a match is found or the list ends.
Time Complexity: O(n)
"""

def linear_search(arr, target):
    # Iterate through indices of the list
    for index in range(len(arr)):
        # If element at current index matches target, return index
        if arr[index] == target:
            return index
            
    # If loop completes without finding target, return -1
    return -1

def main():
    data = [2, 3, 4, 10, 40]
    target = 10
    
    idx = linear_search(data, target)
    
    if idx != -1:
        print(f"🎯 Value {target} found at index {idx}")
    else:
        print(f"❌ Value {target} not found in the list.")

if __name__ == "__main__":
    main()
