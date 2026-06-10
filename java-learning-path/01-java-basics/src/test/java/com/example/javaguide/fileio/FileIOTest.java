package com.example.javaguide.fileio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

class FileIOTest {
    
    @TempDir
    Path tempDir;
    
    @Test
    @DisplayName("Write and read file should work")
    void testWriteAndRead() throws IOException {
        Path file = tempDir.resolve("test.txt");
        String content = "Hello, World!";
        
        FileIODemo.writeToFile(file, content);
        String read = FileIODemo.readFromFile(file);
        
        assertEquals(content, read);
    }
    
    @Test
    @DisplayName("Count lines should work correctly")
    void testCountLines() throws IOException {
        Path file = tempDir.resolve("lines.txt");
        Files.writeString(file, "Line 1\nLine 2\nLine 3\n");
        
        long count = FileIODemo.countLines(file);
        
        assertEquals(3, count);
    }
    
    @Test
    @DisplayName("Copy file should create identical copy")
    void testCopyFile() throws IOException {
        Path source = tempDir.resolve("source.txt");
        Path target = tempDir.resolve("target.txt");
        
        Files.writeString(source, "Test content");
        FileIODemo.copyFile(source, target);
        
        assertTrue(Files.exists(target));
        assertEquals(Files.readString(source), Files.readString(target));
    }
    
    @Test
    @DisplayName("List files should return all files")
    void testListFiles() throws IOException {
        Files.createFile(tempDir.resolve("file1.txt"));
        Files.createFile(tempDir.resolve("file2.txt"));
        
        List<Path> files = FileIODemo.listFiles(tempDir);
        
        assertEquals(2, files.size());
    }
}
