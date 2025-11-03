# Unit Testing with JUnit

## 📋 Learning Goals

- Master JUnit 5 annotations and assertions
- Write effective unit tests
- Use @ParameterizedTest for multiple test cases
- Understand test lifecycle (@BeforeEach, @AfterEach)
- Apply testing best practices and TDD

## 💡 Key Concepts

### 1. JUnit 5 Annotations
- **@Test:** Mark test methods
- **@DisplayName:** Custom test names
- **@BeforeEach/@AfterEach:** Setup/teardown
- **@ParameterizedTest:** Data-driven tests
- **@Disabled:** Skip tests

### 2. Assertions
- assertEquals, assertTrue, assertFalse
- assertNotNull, assertNull
- assertThrows, assertDoesNotThrow
- assertAll (grouped assertions)

### 3. Test Structure (AAA Pattern)
- **Arrange:** Set up test data
- **Act:** Execute code under test
- **Assert:** Verify results

## 🚀 How to Build and Run

```powershell
cd 01-java-basics\unit-testing-junit
mvn clean test
mvn test -Dtest=CalculatorTest
```

## 📤 Expected Output

```
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## 🔨 Exercises

1. Write tests for Calculator class
2. Use @ParameterizedTest with multiple inputs
3. Test exception handling with assertThrows
4. Implement test fixtures with @BeforeEach
5. Practice TDD: write test first, then code

## ⚠️ Common Pitfalls

1. **Test independence:** Each test should be isolated
2. **One assertion per test:** Focus tests
3. **Test naming:** Use descriptive names
4. **Don't test frameworks:** Test your logic

## 🔗 Additional Resources

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
