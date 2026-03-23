/**
 * Exercise 17: Binary Search
 * 
 * ALGORITHM (Requirement: Sorted Array):
 * 1. Find the mid point.
 * 2. If target == mid, done.
 * 3. If target < mid, look in the left half.
 * 4. If target > mid, look in the right half.
 * Time Complexity: O(log n) - Extremely fast.
 */
public class BinarySearch {
    public static void main(String[] args) {
        // MUST BE SORTED
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        
        int result = binarySearch(arr, target);
        
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element " + target + " found at index: " + result);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            // Avoid (left+right)/2 to prevent potential overflow
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not present
        return -1;
    }
}
