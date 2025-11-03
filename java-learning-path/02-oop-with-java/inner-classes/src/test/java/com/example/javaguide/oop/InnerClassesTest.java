package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class InnerClassesTest {
    
    @Test
    @DisplayName("Member inner class should access outer class members")
    void testMemberInnerClass() {
        Outer outer = new Outer(10);
        Outer.Inner inner = outer.new Inner();
        
        assertDoesNotThrow(() -> inner.display());
        
        // Inner class can modify outer members
        inner.modifyOuter();
    }
    
    @Test
    @DisplayName("Static nested class should work without outer instance")
    void testStaticNestedClass() {
        // No need for outer instance
        Outer.StaticNested nested = new Outer.StaticNested();
        
        assertDoesNotThrow(() -> nested.display());
    }
    
    @Test
    @DisplayName("Local inner class should access local variables")
    void testLocalInnerClass() {
        Outer outer = new Outer(20);
        
        assertDoesNotThrow(() -> outer.demonstrateLocalInner());
    }
    
    @Test
    @DisplayName("Anonymous inner class should implement interface")
    void testAnonymousInnerClass() {
        Greeting greeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Test greeting: " + name);
            }
        };
        
        assertDoesNotThrow(() -> greeting.greet("Test"));
    }
    
    @Test
    @DisplayName("Button with anonymous listener should work")
    void testButtonWithListener() {
        Button button = new Button("Test");
        final int[] clickCount = {0};
        
        button.setOnClickListener(new ClickListener() {
            @Override
            public void onClick() {
                clickCount[0]++;
            }
        });
        
        button.click();
        assertEquals(1, clickCount[0]);
    }
    
    @Test
    @DisplayName("LinkedList iterator should work")
    void testLinkedListIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        
        LinkedList<String>.LinkedListIterator iterator = list.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    @Test
    @DisplayName("Builder pattern should construct Person correctly")
    void testBuilderPattern() {
        Person person = new Person.Builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .address("123 Main St")
                .build();
        
        assertNotNull(person);
        String str = person.toString();
        assertTrue(str.contains("John"));
        assertTrue(str.contains("Doe"));
        assertTrue(str.contains("30"));
    }
}
