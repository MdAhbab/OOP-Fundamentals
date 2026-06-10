package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class InterfacesTest {
    
    @Test
    @DisplayName("Drawable implementations should work")
    void testDrawable() {
        Drawable circle = new Circle(5.0);
        Drawable rectangle = new Rectangle(4.0, 6.0);
        
        assertDoesNotThrow(() -> {
            circle.draw();
            rectangle.draw();
        });
    }
    
    @Test
    @DisplayName("SmartPhone should implement multiple interfaces")
    void testMultipleInterfaces() {
        SmartPhone phone = new SmartPhone();
        
        assertTrue(phone instanceof Phone);
        assertTrue(phone instanceof Camera);
        assertTrue(phone instanceof WebBrowser);
        
        assertDoesNotThrow(() -> {
            phone.call("123");
            phone.takePicture();
            phone.browseInternet("test.com");
        });
    }
    
    @Test
    @DisplayName("MusicPlayer default method should work")
    void testDefaultMethod() {
        MusicPlayer player = new MP3Player();
        
        assertDoesNotThrow(() -> {
            player.play();
            player.pause(); // Default method
            player.stop();
        });
    }
    
    @Test
    @DisplayName("Functional interface should work with lambdas")
    void testFunctionalInterface() {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        
        assertEquals(8, add.calculate(5, 3));
        assertEquals(2, subtract.calculate(5, 3));
    }
    
    @Test
    @DisplayName("Student should be comparable")
    void testComparable() {
        Student s1 = new Student("Alice", 85);
        Student s2 = new Student("Bob", 90);
        
        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s2.compareTo(s1) > 0);
        assertEquals(0, s1.compareTo(s1));
    }
}
