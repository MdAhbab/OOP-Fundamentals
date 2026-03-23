/**
 * Exercise 06: Right-Angled Triangle Pattern
 * 
 * ALGORITHM:
 * Row 1 prints 1 star.
 * Row 2 prints 2 stars.
 * ...
 * Row i prints i stars.
 */
public class RightTrianglePattern {
    public static void main(String[] args) {
        int rows = 5;
        
        // Outer loop controls the current row
        for (int i = 1; i <= rows; i++) {
            
            // Inner loop controls how many stars to print in the current row
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            // Move to the next line after finishing a row
            System.out.println();
        }
    }
}
