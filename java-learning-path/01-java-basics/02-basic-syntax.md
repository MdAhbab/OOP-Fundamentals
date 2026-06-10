# Basic Syntax

## Overview
This topic covers the fundamental building blocks of every Java program — the syntax rules you must know before writing any real code.

## Key Concepts
- **Program Structure**: Every Java program runs from `public static void main(String[] args)`
- **Console Output**: `System.out.println()`, `print()`, `printf()`
- **Comments**: Single-line (`//`), multi-line (`/* */`), Javadoc (`/** */`)
- **Statements & Blocks**: Semicolons terminate statements; braces `{ }` group them
- **Naming Conventions**: camelCase (variables/methods), PascalCase (classes), UPPER_SNAKE_CASE (constants)
- **Primitive Types**: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`
- **Type Casting**: Widening (automatic, safe) vs Narrowing (manual, may lose data)

## Running
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.example.javaguide.basicsyntax.BasicSyntaxDemo"
mvn test
```
