import java.util.Scanner;

/**
 * Exercise 02: Fibonacci Sequence
 * 
 * ALGORITHM:
 * Next term = Sum of the previous two terms.
 * f(1) = 0, f(2) = 1, f(3) = (0+1) = 1, f(4) = (1+1) = 2, ...
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        int first = 0, second = 1;
        System.out.print("Fibonacci Sequence up to " + n + " terms: ");

        // Loop to generate and print terms
        for (int i = 1; i <= n; ++i) {
            System.out.print(first + (i == n ? "" : ", "));
            
            // Calculate the next term
            int next = first + second;
            
            // Update pointers: 'first' moves to 'second', 'second' moves to 'next'
            first = second;
            second = next;
        }
        System.out.println();
        scanner.close();
    }
}
