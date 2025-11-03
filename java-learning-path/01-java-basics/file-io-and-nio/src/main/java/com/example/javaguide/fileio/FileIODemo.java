package com.example.javaguide.fileio;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * FileIODemo - Demonstrates file input/output operations
 */
public class FileIODemo {
    
    public static void main(String[] args) {
        try {
            demonstrateBasicFileIO();
            demonstrateNIO();
            demonstrateDirectoryOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void demonstrateBasicFileIO() throws IOException {
        System.out.println("=== Basic File I/O ===");
        
        Path tempFile = Files.createTempFile("demo", ".txt");
        
        // Write using BufferedWriter
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.write("Hello, File I/O!");
            writer.newLine();
            writer.write("Second line");
        }
        
        System.out.println("File written: " + tempFile);
        
        // Read using BufferedReader
        try (BufferedReader reader = Files.newBufferedReader(tempFile, StandardCharsets.UTF_8)) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        }
        
        Files.deleteIfExists(tempFile);
        System.out.println();
    }
    
    public static void demonstrateNIO() throws IOException {
        System.out.println("=== NIO.2 Demo ===");
        
        Path tempFile = Files.createTempFile("nio-demo", ".txt");
        
        // Write all lines
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
        Files.write(tempFile, lines, StandardCharsets.UTF_8);
        
        System.out.println("File created: " + tempFile);
        
        // Read all lines
        List<String> readLines = Files.readAllLines(tempFile, StandardCharsets.UTF_8);
        System.out.println("Lines read: " + readLines);
        
        // File attributes
        System.out.println("File size: " + Files.size(tempFile) + " bytes");
        System.out.println("Is regular file: " + Files.isRegularFile(tempFile));
        System.out.println("Is readable: " + Files.isReadable(tempFile));
        
        Files.deleteIfExists(tempFile);
        System.out.println();
    }
    
    public static void demonstrateDirectoryOperations() throws IOException {
        System.out.println("=== Directory Operations ===");
        
        Path tempDir = Files.createTempDirectory("demo-dir");
        System.out.println("Directory created: " + tempDir);
        
        // Create files in directory
        Files.createFile(tempDir.resolve("file1.txt"));
        Files.createFile(tempDir.resolve("file2.txt"));
        
        // List directory contents
        System.out.println("Directory contents:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(tempDir)) {
            for (Path entry : stream) {
                System.out.println("  " + entry.getFileName());
            }
        }
        
        // Clean up
        Files.walk(tempDir)
            .sorted(Comparator.reverseOrder())
            .forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        
        System.out.println();
    }
    
    // Utility methods
    
    public static void writeToFile(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
    
    public static String readFromFile(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
    
    public static long countLines(Path path) throws IOException {
        try (var lines = Files.lines(path)) {
            return lines.count();
        }
    }
    
    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static List<Path> listFiles(Path directory) throws IOException {
        List<Path> files = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            stream.forEach(files::add);
        }
        return files;
    }
}
