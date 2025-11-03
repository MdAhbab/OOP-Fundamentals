package com.example.javaguide.maven;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Maven Demo Tests")
class MavenDemoTest {
    
    @Test
    @DisplayName("Addition should work correctly")
    void testAdd() {
        int result = MavenDemo.add(2, 3);
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("Project version should be set")
    void testGetProjectVersion() {
        String version = MavenDemo.getProjectVersion();
        assertNotNull(version);
        assertTrue(version.contains("SNAPSHOT") || version.matches("\\d+\\.\\d+\\.\\d+"));
    }
    
    @Test
    @DisplayName("All demo methods should execute without errors")
    void testDemoMethods() {
        assertDoesNotThrow(() -> {
            MavenDemo.demonstrateProjectInfo();
            MavenDemo.demonstrateDependencyManagement();
            MavenDemo.demonstrateLifecycle();
        });
    }
}
