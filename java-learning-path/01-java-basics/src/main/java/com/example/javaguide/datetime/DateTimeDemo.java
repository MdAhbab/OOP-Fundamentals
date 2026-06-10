package com.example.javaguide.datetime;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

/**
 * DateTimeDemo - Demonstrates Java Date/Time API (java.time package) integrations natively.
 * 
 * Provides explicit implementations illustrating immutable LocalDate formatting, temporal manipulations,
 * Period measurements, parsing transformations, and time duration architectures comprehensively.
 */
public class DateTimeDemo {
    
    /**
     * Main execution entry tracking standard date demonstrations structurally.
     */
    public static void main(String[] args) {
        demonstrateLocalDate();
        demonstrateLocalTime();
        demonstrateLocalDateTime();
        demonstratePeriodAndDuration();
        demonstrateFormatting();
    }
    
    /**
     * Manipulates isolated LocalDate representations defining generic calendar bounds exclusively.
     */
    public static void demonstrateLocalDate() {
        System.out.println("=== LocalDate Demo ===");
        
        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        
        // Specific date
        LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 15);
        System.out.println("Birthday: " + birthday);
        
        // Date arithmetic
        LocalDate tomorrow = today.plusDays(1);
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate nextMonth = today.plusMonths(1);
        
        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Next week: " + nextWeek);
        System.out.println("Next month: " + nextMonth);
        
        // Date comparison
        System.out.println("Is today after birthday: " + today.isAfter(birthday));
        System.out.println();
    }
    
    /**
     * Captures time isolated formats operating identically without referencing any dates mechanically.
     */
    public static void demonstrateLocalTime() {
        System.out.println("=== LocalTime Demo ===");
        
        // Current time
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);
        
        // Specific time
        LocalTime lunchTime = LocalTime.of(12, 30);
        System.out.println("Lunch time: " + lunchTime);
        
        // Time arithmetic
        LocalTime later = now.plusHours(2);
        System.out.println("2 hours later: " + later);
        System.out.println();
    }
    
    /**
     * Unifies structured time boundaries exposing full combinations dynamically capturing instants natively.
     */
    public static void demonstrateLocalDateTime() {
        System.out.println("=== LocalDateTime Demo ===");
        
        // Current date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);
        
        // Specific date and time
        LocalDateTime meeting = LocalDateTime.of(2025, 11, 15, 14, 30);
        System.out.println("Meeting: " + meeting);
        
        // Extract components
        System.out.println("Year: " + now.getYear());
        System.out.println("Month: " + now.getMonth());
        System.out.println("Day: " + now.getDayOfMonth());
        System.out.println("Hour: " + now.getHour());
        System.out.println();
    }
    
    /**
     * Defines length intervals mathematically distinguishing generic Periods (Dates) against Durations (Times).
     */
    public static void demonstratePeriodAndDuration() {
        System.out.println("=== Period and Duration ===");
        
        // Period (date-based)
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 11, 3);
        Period period = Period.between(startDate, endDate);
        
        System.out.println("Period: " + period);
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
        
        // Duration (time-based)
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        Duration duration = Duration.between(start, end);
        
        System.out.println("Duration: " + duration);
        System.out.println("Hours: " + duration.toHours());
        System.out.println("Minutes: " + duration.toMinutes());
        System.out.println();
    }
    
    /**
     * Outlines custom standard pattern combinations enabling raw String parsing correctly back into Time interfaces.
     */
    public static void demonstrateFormatting() {
        System.out.println("=== Formatting and Parsing ===");
        
        LocalDateTime now = LocalDateTime.now();
        
        // Predefined formatters
        System.out.println("ISO_DATE_TIME: " + now.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("ISO_DATE: " + now.format(DateTimeFormatter.ISO_DATE));
        
        // Custom formatter
        DateTimeFormatter custom = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Custom: " + now.format(custom));
        
        // Parsing
        String dateStr = "15/11/2025 14:30:00";
        LocalDateTime parsed = LocalDateTime.parse(dateStr, custom);
        System.out.println("Parsed: " + parsed);
        System.out.println();
    }
    
    // Utility methods
    
    /**
     * Calculates absolute age difference explicitly finding year intervals generically natively.
     * 
     * @param birthDate User targeted LocalDate origin
     * @return Passed chronological years representing simple age values
     */
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    /**
     * Determines granular interval distances isolating numerical days precisely separating bounds.
     * 
     * @param start Foundational origin target date
     * @param end Termination chronological endpoint sequence
     * @return Integer long scalar value corresponding entirely towards absolute separated target days.
     */
    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }
    
    /**
     * Categorizes calendar values verifying weekend limits mathematically explicitly.
     * 
     * @param date Calendar representation requiring mapping validation
     * @return True specifically whenever limits match weekends directly
     */
    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    
    /**
     * Filters chronologies identifying the subsequent weekday boundary universally circumventing weekends functionally.
     * 
     * @param date Origin standard reference map
     * @return First target sequence explicitly missing weekend boundaries mechanically via Chrono loop patterns
     */
    public static LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate next = date.plusDays(1);
        while (isWeekend(next)) {
            next = next.plusDays(1);
        }
        return next;
    }
}
