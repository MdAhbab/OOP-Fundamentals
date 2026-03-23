import java.util.Arrays;

/**
 * Exercise 13: Insertion Sort
 * 
 * ALGORITHM:
 * Pick elements one by one from the unsorted part and "insert" them into 
 * their relative position in the sorted part (similar to sorting playing cards).
 * Time Complexity: O(n^2) - Best case O(n) for already sorted arrays.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // Element currently being placed
            int j = i - 1;

            /* Compare 'key' with elements to its left (the sorted part)
               and shift elements larger than 'key' one position to the right */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            // Insert 'key' into its calculated position
            arr[j + 1] = key;
        }
    }
}
