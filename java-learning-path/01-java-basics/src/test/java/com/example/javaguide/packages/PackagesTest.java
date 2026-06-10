package com.example.javaguide.packages;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import com.example.javaguide.packages.util.Helper;
import com.example.javaguide.packages.model.Sample;

class PackagesTest {
    
    @Test
    @DisplayName("Helper class should be accessible from test package")
    void testHelperAccess() {
        Helper helper = new Helper();
        assertNotNull(helper);
        assertEquals(15, helper.add(10, 5));
        assertEquals("[test]", helper.format("test"));
    }
    
    @Test
    @DisplayName("Sample class should work correctly")
    void testSampleClass() {
        Sample sample = new Sample("test value");
        assertEquals("test value", sample.getValue());
        
        sample.setValue("new value");
        assertEquals("new value", sample.getValue());
    }
    
    @Test
    @DisplayName("Static imports should work")
    void testStaticImports() {
        // Using Math.PI and Math.sqrt (statically imported in main class)
        assertEquals(3.14159, Math.PI, 0.00001);
        assertEquals(4.0, Math.sqrt(16), 0.001);
    }
}
