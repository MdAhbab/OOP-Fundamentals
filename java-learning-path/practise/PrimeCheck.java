import java.util.Scanner;

/**
 * Exercise 03: Prime Number Checker
 * 
 * ALGORITHM:
 * 1. A prime number is > 1.
 * 2. If it is divisible by any integer from 2 to the square root of itself, it's not prime.
 *    (Optimization: We only check up to sqrt(n) because factors come in pairs).
 */
public class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // 0 and 1 are not prime numbers
        boolean isPrime = num > 1;
        
        // Loop from 2 up to square root of num
        // Efficiency: If num has a factor larger than sqrt(num), it must also have one smaller than sqrt(num).
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false; // Found a factor, so not prime
                break;       // Exit loop early for efficiency
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }
        scanner.close();
    }
}
