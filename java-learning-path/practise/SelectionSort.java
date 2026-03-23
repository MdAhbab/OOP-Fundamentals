import java.util.Arrays;

/**
 * Exercise 12: Selection Sort
 * 
 * ALGORITHM:
 * 1. Find the smallest element in the unsorted part.
 * 2. Swap it with the first unsorted element.
 * 3. Repeat for the remaining portion.
 * Time Complexity: O(n^2) - Fixed number of comparisons.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Traverse the entire array
        for (int i = 0; i < n - 1; i++) {
            // Assume the current index 'i' holds the minimum
            int minIdx = i;
            
            // Loop through indices i+1 to n to find a smaller value
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j; // Update index of minimum value
                }
            }
            
            // Swap the found minimum with the element at index 'i'
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
