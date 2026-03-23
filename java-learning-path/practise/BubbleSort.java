import java.util.Arrays;

/**
 * Exercise 11: Bubble Sort
 * 
 * ALGORITHM (Sinking Sort):
 * In each pass, the largest element "bubbles up" to its correct position at the end.
 * Time Complexity: O(n^2) - Nested loops.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted: " + Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop controls number of passes
        for (int i = 0; i < n - 1; i++) {
            
            // Inner loop does the comparisons and swaps
            // Optimization: 'n - i - 1' because the last 'i' elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                
                // Swap if the current element is greater than the next one
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
