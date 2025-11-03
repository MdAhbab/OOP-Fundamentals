package com.example.javaguide.setup;

/**
 * SetupDemo - Verifies Java development environment setup
 * 
 * This class demonstrates:
 * - Running a basic Java application
 * - Accessing system properties
 * - Console output
 * 
 * @author Java Learning Path
 * @version 1.0
 */
public class SetupDemo {
    
    /**
     * Main entry point for the application
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Java Setup Verification ===");
        
        // Display Java version information
        String javaVersion = System.getProperty("java.version");
        String javaHome = System.getProperty("java.home");
        
        System.out.println("Java Version: " + javaVersion);
        System.out.println("Java Home: " + javaHome);
        
        // Display operating system information
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        
        System.out.println("OS Name: " + osName);
        System.out.println("OS Architecture: " + osArch);
        
        // Display user directory
        String userDir = System.getProperty("user.dir");
        System.out.println("User Directory: " + userDir);
        
        System.out.println("===============================");
        System.out.println("Setup verification complete!");
        
        // Demonstrate some basic calculations to verify JVM
        int result = performBasicCalculation(10, 5);
        System.out.println("Basic calculation test: 10 + 5 = " + result);
    }
    
    /**
     * Performs a basic calculation to verify method execution
     * 
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    public static int performBasicCalculation(int a, int b) {
        return a + b;
    }
    
    /**
     * Returns the Java version as a string
     * 
     * @return Java version
     */
    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }
    
    /**
     * Checks if the Java version is 17 or higher
     * 
     * @return true if Java 17+, false otherwise
     */
    public static boolean isJava17OrHigher() {
        String version = System.getProperty("java.version");
        // Extract major version (e.g., "17" from "17.0.1")
        String majorVersion = version.split("\\.")[0];
        try {
            int major = Integer.parseInt(majorVersion);
            return major >= 17;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
