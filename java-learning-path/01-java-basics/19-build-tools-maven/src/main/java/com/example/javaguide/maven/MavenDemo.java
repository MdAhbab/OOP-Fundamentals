package com.example.javaguide.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MavenDemo - Demonstrates Maven build tool concepts
 */
public class MavenDemo {
    
    private static final Logger logger = LoggerFactory.getLogger(MavenDemo.class);
    
    public static void main(String[] args) {
        logger.info("=== Maven Build Tool Demo ===");
        
        demonstrateProjectInfo();
        demonstrateDependencyManagement();
        demonstrateLifecycle();
    }
    
    public static void demonstrateProjectInfo() {
        logger.info("Project Information:");
        logger.info("  GroupId: com.example.javaguide");
        logger.info("  ArtifactId: build-tools-maven");
        logger.info("  Version: 1.0-SNAPSHOT");
        logger.info("  Packaging: JAR");
        System.out.println();
    }
    
    public static void demonstrateDependencyManagement() {
        logger.info("Dependency Management:");
        logger.info("  Dependencies are declared in pom.xml");
        logger.info("  Maven downloads from Central Repository");
        logger.info("  Stored in ~/.m2/repository");
        logger.info("  Transitive dependencies resolved automatically");
        System.out.println();
    }
    
    public static void demonstrateLifecycle() {
        logger.info("Maven Build Lifecycle:");
        logger.info("  1. clean - Remove target directory");
        logger.info("  2. validate - Validate project");
        logger.info("  3. compile - Compile source code");
        logger.info("  4. test - Run unit tests");
        logger.info("  5. package - Create JAR file");
        logger.info("  6. install - Install to local repository");
        logger.info("  7. deploy - Deploy to remote repository");
        System.out.println();
    }
    
    public static String getProjectVersion() {
        // In real projects, this would be read from pom.xml
        return "1.0-SNAPSHOT";
    }
    
    public static int add(int a, int b) {
        logger.debug("Adding {} and {}", a, b);
        return a + b;
    }
}
