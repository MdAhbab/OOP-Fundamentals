package com.example.javaguide.datetime;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

/**
 * DateTimeDemo - Demonstrates Java Date/Time API (java.time package)
 */
public class DateTimeDemo {
    
    public static void main(String[] args) {
        demonstrateLocalDate();
        demonstrateLocalTime();
        demonstrateLocalDateTime();
        demonstratePeriodAndDuration();
        demonstrateFormatting();
    }
    
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
    
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }
    
    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    
    public static LocalDate getNextWorkingDay(LocalDate date) {
        LocalDate next = date.plusDays(1);
        while (isWeekend(next)) {
            next = next.plusDays(1);
        }
        return next;
    }
}
