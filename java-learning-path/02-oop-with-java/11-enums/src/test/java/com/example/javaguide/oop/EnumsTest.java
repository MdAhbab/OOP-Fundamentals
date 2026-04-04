package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EnumsTest {

    @Test
    @DisplayName("Day enum should have 7 constants")
    void testDayCount() {
        assertEquals(7, EnumsDemo.getDayCount());
    }

    @Test
    @DisplayName("Earth gravity should be approximately 9.8 m/s²")
    void testEarthGravity() {
        double gravity = EnumsDemo.getEarthGravity();
        assertTrue(gravity > 9.7 && gravity < 9.9,
                "Expected ~9.8 but got " + gravity);
    }

    @Test
    @DisplayName("Season valueOf should return correct constant")
    void testSeasonValueOf() {
        assertEquals(EnumsDemo.Season.SUMMER,
                EnumsDemo.Season.valueOf("SUMMER"));
    }

    @Test
    @DisplayName("TrafficLight should have exactly 3 values")
    void testTrafficLightValues() {
        assertEquals(3, EnumsDemo.TrafficLight.values().length);
    }

    @Test
    @DisplayName("Main method should run without errors")
    void testMainRuns() {
        assertDoesNotThrow(() -> EnumsDemo.main(new String[]{}));
    }
}
