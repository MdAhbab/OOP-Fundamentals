/**
 * Exercise 07: Pyramid Pattern
 * 
 * ALGORITHM:
 * 1. Spaces: decrease by 1 each row (from rows-1 down to 0).
 * 2. Stars: increase as (2 * current_row - 1).
 */
public class PyramidPattern {
    public static void main(String[] args) {
        int rows = 5;
        
        for (int i = 1; i <= rows; i++) {
            
            // Sub-loop 1: Print leading spaces to center the pyramid
            // Row 1: 4 spaces, Row 2: 3 spaces...
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            
            // Sub-loop 2: Print stars
            // Arithmetic progression: 1, 3, 5, 7, 9... (2i - 1)
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            
            // New line after formatting current row
            System.out.println();
        }
    }
}
