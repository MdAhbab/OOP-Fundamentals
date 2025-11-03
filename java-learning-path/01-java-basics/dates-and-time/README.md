# Dates and Time

## 📋 Learning Goals

- Master LocalDate, LocalTime, LocalDateTime
- Work with Period and Duration
- Format and parse dates
- Understand time zones with ZonedDateTime
- Manipulate temporal objects

## 💡 Key Concepts

### 1. Key Classes (java.time package - Java 8+)
- **LocalDate:** Date without time
- **LocalTime:** Time without date
- **LocalDateTime:** Date and time without timezone
- **ZonedDateTime:** Date and time with timezone
- **Instant:** Machine timestamp
- **Period:** Date-based duration (years, months, days)
- **Duration:** Time-based duration (hours, minutes, seconds)

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\dates-and-time
mvn clean compile
mvn exec:java
mvn test
```

## 📤 Expected Output

```
=== Date/Time Demo ===
Today: 2025-11-03
Current time: 14:30:25
```

## 🔨 Exercises

1. Calculate age from birthdate
2. Find days between two dates
3. Add/subtract months from date
4. Convert between timezones
5. Parse custom date formats

## ⚠️ Common Pitfalls

1. **Legacy Date/Calendar:** Use java.time, not java.util.Date
2. **Immutability:** All java.time objects are immutable
3. **Timezone awareness:** LocalDateTime has no timezone
4. **Null handling:** Use Optional or validation

## 🔗 Additional Resources

- [Oracle: Date Time API](https://docs.oracle.com/javase/tutorial/datetime/)
