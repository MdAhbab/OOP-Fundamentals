/**
 * Exercise 10: FizzBuzz
 * 
 * LOGIC:
 * - Check divisibility by both 3 AND 5 FIRST (the most specific condition).
 * - Then check 5 or 3 individually.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            // Condition for multiples of both 3 and 5 (e.g., 15, 30, 45)
            // Tip: (i % 3 == 0 && i % 5 == 0) is the same as (i % 15 == 0)
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } 
            // Condition for multiples of 3 only
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            } 
            // Condition for multiples of 5 only
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            } 
            // Otherwise, print the number
            else {
                System.out.println(i);
            }
        }
    }
}
