# Build Tools - Maven

## 📋 Learning Goals

- Understand Maven project structure and conventions
- Master the Project Object Model (POM)
- Learn Maven lifecycle phases
- Manage dependencies effectively
- Use Maven plugins and profiles

## 💡 Key Concepts

### 1. Maven Coordinates (GAV)
- **groupId:** Organization/project identifier
- **artifactId:** Project module name
- **version:** Project version

### 2. Maven Lifecycle
- **clean:** Remove build artifacts
- **validate:** Validate project structure
- **compile:** Compile source code
- **test:** Run unit tests
- **package:** Create JAR/WAR
- **install:** Install to local repository
- **deploy:** Deploy to remote repository

### 3. Dependency Scopes
- **compile:** Default, available everywhere
- **test:** Only for testing
- **provided:** Provided by container/JDK
- **runtime:** Not needed for compilation

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\build-tools-maven
mvn clean compile    # Compile
mvn test            # Run tests
mvn package         # Create JAR
mvn clean install   # Full build
```

## 📤 Expected Output

```
[INFO] BUILD SUCCESS
[INFO] Total time: 2.156 s
```

## 🔨 Exercises

1. Add a new dependency to POM
2. Create a multi-module project
3. Use Maven properties for version management
4. Configure Maven Compiler Plugin for Java 17
5. Create a custom Maven profile

## ⚠️ Common Pitfalls

1. **Dependency conflicts:** Use `mvn dependency:tree`
2. **SNAPSHOT versions:** Unstable in production
3. **Local repository:** Clear ~/.m2/repository if issues
4. **Plugin versions:** Always specify versions

## 🔗 Additional Resources

- [Maven Documentation](https://maven.apache.org/guides/)
- [Maven Central Repository](https://search.maven.org/)
