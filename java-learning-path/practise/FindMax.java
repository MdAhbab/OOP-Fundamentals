import java.util.Arrays;

/**
 * Exercise 09: Find Maximum in Array
 * 
 * ALGORITHM:
 * 1. Assume the first element is the maximum.
 * 2. Compare this assumed max with every other element.
 * 3. Update max whenever a larger element is found.
 */
public class FindMax {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 7, 23, 56, 89, 34};
        
        // 1. Initialize max with the first element of the array
        int max = numbers[0];
        
        // 2. Iterate through the array starting from the second element
        for (int i = 1; i < numbers.length; i++) {
            // 3. Compare current element with assumed max
            if (numbers[i] > max) {
                max = numbers[i]; // New maximum found, update it
            }
        }

        System.out.println("Array Contents: " + Arrays.toString(numbers));
        System.out.println("Largest Element: " + max);
    }
}
