/**
 * Exercise 16: Linear Search
 * 
 * ALGORITHM:
 * Simply scan the array from left to right.
 * Best for small or unsorted data.
 * Time Complexity: O(n)
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        
        int result = search(arr, target);
        
        if (result == -1)
            System.out.println("Element not found in searching.");
        else
            System.out.println("Element " + target + " found at index: " + result);
    }

    /**
     * @return index of target, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            // Found the value
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Exhausted array without finding it
    }
}
