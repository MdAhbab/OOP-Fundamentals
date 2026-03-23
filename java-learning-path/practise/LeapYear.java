import java.util.Scanner;

/**
 * Exercise 01: Leap Year Checker
 * 
 * ALGORITHM:
 * 1. If a year is divisible by 4, it MIGHT be a leap year.
 * 2. If it is also divisible by 100, it is NOT a leap year UNLESS:
 * 3. It is also divisible by 400.
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        
        // Handle potential non-integer input gracefully
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a numeric year.");
            return;
        }
        
        int year = scanner.nextInt();

        boolean isLeap = false;
        
        // Step 1: Check divisibility by 4
        if (year % 4 == 0) {
            // Step 2: Century years (ending in 00) must be divisible by 400
            if (year % 100 == 0) {
                isLeap = (year % 400 == 0); // Divisible by 400 -> true, else -> false
            } else {
                isLeap = true; // Divisible by 4 but not by 100
            }
        }

        // Output the result
        if (isLeap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        
        scanner.close();
    }
}
