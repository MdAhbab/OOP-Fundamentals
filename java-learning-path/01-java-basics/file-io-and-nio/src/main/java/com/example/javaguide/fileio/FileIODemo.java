package com.example.javaguide.fileio;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * FileIODemo - Demonstrates fundamental file input/output and NIO operations.
 * 
 * Includes classic I/O implementations utilizing basic structural reader classes
 * alongside NIO updates featuring functional syntax and deeper configurations. 
 */
public class FileIODemo {
    
    /**
     * Centralized execution loop firing file demonstration blocks sequentially.
     */
    public static void main(String[] args) {
        try {
            demonstrateBasicFileIO();
            demonstrateNIO();
            demonstrateDirectoryOperations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrates primary buffered writing utilizing java.nio packages along with internal IO structures.
     * 
     * @throws IOException upon IO execution path failure
     */
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
    
    /**
     * Outlines NIO component attributes allowing immediate array extraction logic patterns.
     * 
     * @throws IOException referencing system file extraction exceptions dynamically
     */
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
    
    /**
     * Defines deep system directory configurations including child population creation, 
     * lookup loop enumeration, and absolute purging behaviors mapping deletion.
     * 
     * @throws IOException dynamically parsing tree structures fault boundaries manually
     */
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
    
    /**
     * Directly inserts string characters universally mapping standard NIO interfaces natively.
     * 
     * @param path Defined destination target file configurations
     * @param content Raw generic character injection references
     * @throws IOException matching file bounds error exceptions
     */
    public static void writeToFile(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
    
    /**
     * Translates local targeted files executing NIO read definitions string interpretations directly.
     * 
     * @param path Defined source location target file reference
     * @return Output decoded String component sequences mappings
     * @throws IOException referencing external input/output path block resolutions
     */
    public static String readFromFile(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
    
    /**
     * Accumulates defined elements mathematically finding maximum vertical column boundaries line by line.
     * 
     * @param path Identified sequential component file map reference
     * @return Mathematical sum array dimension scalar mapping line totals
     * @throws IOException highlighting mapping reference parse failures
     */
    public static long countLines(Path path) throws IOException {
        try (var lines = Files.lines(path)) {
            return lines.count();
        }
    }
    
    /**
     * Formats identical clones structurally over targeting directory tree layouts via File copies directly.
     * 
     * @param source Primary source structural target component references
     * @param target Assigned structural output endpoint defining references
     * @throws IOException dynamically linking output file structure boundaries 
     */
    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
    
    /**
     * Recursively references targeted file directories compiling List collection parameters mapping entries physically.
     * 
     * @param directory Targeted path folder mapping origin point array layouts
     * @return Validated List encapsulating distinct target files found within folder structures
     * @throws IOException defining input enumeration logic mapping boundaries
     */
    public static List<Path> listFiles(Path directory) throws IOException {
        List<Path> files = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            stream.forEach(files::add);
        }
        return files;
    }
}
