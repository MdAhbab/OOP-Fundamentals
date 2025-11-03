# File I/O and NIO

## 📋 Learning Goals

- Read and write files using different approaches
- Master BufferedReader, BufferedWriter, Files class
- Understand NIO.2 (Path, Files, DirectoryStream)
- Work with file attributes and permissions
- Handle file operations efficiently

## 💡 Key Concepts

### 1. Traditional I/O (java.io)
- FileReader, FileWriter
- BufferedReader, BufferedWriter
- File, FileInputStream, FileOutputStream

### 2. NIO.2 (java.nio.file - Java 7+)
- **Path:** File system paths
- **Files:** Static utility methods
- **DirectoryStream:** Iterate directories

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\file-io-and-nio
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== File I/O Demo ===
File created: test.txt
Content written successfully
Content read: Hello, File I/O!
```

## 🔨 Exercises

1. Copy file contents to another file
2. List all files in directory
3. Count lines in a text file
4. Read/write JSON or CSV files
5. Monitor directory for changes

## ⚠️ Common Pitfalls

1. **Resource leaks:** Use try-with-resources
2. **Path separators:** Use Path for cross-platform code
3. **Character encoding:** Specify charset explicitly
4. **File existence:** Check before reading

## 🔗 Additional Resources

- [Oracle: File I/O](https://docs.oracle.com/javase/tutorial/essential/io/)
