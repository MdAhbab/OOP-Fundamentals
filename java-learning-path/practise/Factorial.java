import java.util.Scanner;

/**
 * Exercise 05: Factorial Calculation
 * 
 * ALGORITHM:
 * n! = n * (n-1) * (n-2) * ... * 1
 * e.g., 5! = 5 * 4 * 3 * 2 * 1 = 120
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int num = scanner.nextInt();
        
        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }

        // Use long because factorial values grow very fast
        long factorial = 1;
        
        // Iterative approach: multiply 1 up to num
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + num + " is " + factorial);
        scanner.close();
    }
}
