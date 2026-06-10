package com.example.javaguide.datetime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

class DateTimeTest {
    
    @Test
    @DisplayName("Calculate age should work correctly")
    void testCalculateAge() {
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        int age = DateTimeDemo.calculateAge(birthDate);
        
        assertTrue(age >= 34); // As of 2024+
    }
    
    @Test
    @DisplayName("Days between should calculate correctly")
    void testDaysBetween() {
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 1, 11);
        
        long days = DateTimeDemo.daysBetween(start, end);
        assertEquals(10, days);
    }
    
    @Test
    @DisplayName("Weekend detection should work")
    void testIsWeekend() {
        LocalDate saturday = LocalDate.of(2025, 11, 1); // Saturday
        LocalDate monday = LocalDate.of(2025, 11, 3); // Monday
        
        assertTrue(DateTimeDemo.isWeekend(saturday));
        assertFalse(DateTimeDemo.isWeekend(monday));
    }
    
    @Test
    @DisplayName("Next working day should skip weekends")
    void testGetNextWorkingDay() {
        LocalDate friday = LocalDate.of(2025, 10, 31);
        LocalDate nextWorking = DateTimeDemo.getNextWorkingDay(friday);
        
        // Should be Monday
        assertEquals(DayOfWeek.MONDAY, nextWorking.getDayOfWeek());
    }
}
