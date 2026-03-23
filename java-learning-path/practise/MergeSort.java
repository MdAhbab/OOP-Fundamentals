import java.util.Arrays;

/**
 * Exercise 14: Merge Sort
 * 
 * ALGORITHM: Divide and Conquer
 * 1. Split array into halves recursively.
 * 2. Merge back sorted halves.
 * Time Complexity: O(n log n) - Very efficient for large datasets.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    // Recursive function to divide the array
    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find midpoint to avoid overflow for large l, r
            int m = l + (r - l) / 2;

            // Sort left and right halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the result
            merge(arr, l, m, r);
        }
    }

    // Helper function to merge two sorted sub-arrays
    public static void merge(int[] arr, int l, int m, int r) {
        // Sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into original
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++; k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++; k++;
        }
    }
}
