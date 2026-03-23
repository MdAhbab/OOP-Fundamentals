import java.util.Arrays;

/**
 * Exercise 15: Quick Sort
 * 
 * ALGORITHM: Divide and Conquer
 * 1. Choose a "pivot" element (here, we pick the last one).
 * 2. Place pivot at its correct sorted position.
 * 3. Recursively sort elements to the left and right of pivot.
 * Time Complexity: O(n log n) average, O(n^2) worst case.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /* Takes last element as pivot, places pivot at correct position, 
       and places all smaller to left and all larger to right */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap pivot into its final resting place
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the position where sorting is anchored
    }
}
