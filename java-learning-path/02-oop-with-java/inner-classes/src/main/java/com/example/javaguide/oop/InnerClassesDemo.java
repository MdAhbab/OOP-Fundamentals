package com.example.javaguide.oop;

/**
 * InnerClassesDemo - Demonstrates inner classes in Java
 */
public class InnerClassesDemo {
    
    public static void main(String[] args) {
        demonstrateMemberInnerClass();
        demonstrateStaticNestedClass();
        demonstrateLocalInnerClass();
        demonstrateAnonymousInnerClass();
    }
    
    public static void demonstrateMemberInnerClass() {
        System.out.println("=== Member Inner Class ===");
        
        Outer outer = new Outer(10);
        Outer.Inner inner = outer.new Inner();
        inner.display();
        System.out.println();
    }
    
    public static void demonstrateStaticNestedClass() {
        System.out.println("=== Static Nested Class ===");
        
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.display();
        System.out.println();
    }
    
    public static void demonstrateLocalInnerClass() {
        System.out.println("=== Local Inner Class ===");
        
        Outer outer = new Outer(20);
        outer.demonstrateLocalInner();
        System.out.println();
    }
    
    public static void demonstrateAnonymousInnerClass() {
        System.out.println("=== Anonymous Inner Class ===");
        
        AnonymousDemo demo = new AnonymousDemo();
        demo.demonstrateAnonymousClass();
        System.out.println();
    }
}

// Member Inner Class
class Outer {
    private int value;
    private static String className = "Outer";
    
    public Outer(int value) {
        this.value = value;
    }
    
    // Member inner class (non-static)
    class Inner {
        private int innerValue = 100;
        
        void display() {
            // Can access outer class members (including private)
            System.out.println("Outer value: " + value);
            System.out.println("Inner value: " + innerValue);
            System.out.println("Outer class name: " + className);
            
            // Access outer this
            System.out.println("Outer this: " + Outer.this);
        }
        
        void modifyOuter() {
            value = 999; // Can modify outer class members
        }
    }
    
    // Static nested class
    static class StaticNested {
        void display() {
            // Can only access static members of outer class
            System.out.println("Class name: " + className);
            // Cannot access: value // Compile error
        }
    }
    
    // Method with local inner class
    void demonstrateLocalInner() {
        int localVar = 30; // Effectively final
        
        // Local inner class
        class LocalInner {
            void show() {
                System.out.println("Outer value: " + value);
                System.out.println("Local var: " + localVar);
            }
        }
        
        LocalInner local = new LocalInner();
        local.show();
    }
}

// Anonymous Inner Class
interface Greeting {
    void greet(String name);
}

abstract class AbstractGreeting {
    abstract void sayHello();
}

class AnonymousDemo {
    void demonstrateAnonymousClass() {
        // Anonymous class implementing interface
        Greeting greeting = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };
        greeting.greet("Alice");
        
        // Anonymous class extending abstract class
        AbstractGreeting abstractGreeting = new AbstractGreeting() {
            @Override
            void sayHello() {
                System.out.println("Hello from anonymous class");
            }
        };
        abstractGreeting.sayHello();
        
        // Compare with lambda (for functional interfaces)
        Greeting lambdaGreeting = name -> System.out.println("Hi, " + name + "!");
        lambdaGreeting.greet("Bob");
    }
}

// Real-world example: Event Listener
interface ClickListener {
    void onClick();
}

class Button {
    private String label;
    private ClickListener listener;
    
    public Button(String label) {
        this.label = label;
    }
    
    public void setOnClickListener(ClickListener listener) {
        this.listener = listener;
    }
    
    public void click() {
        System.out.println("Button '" + label + "' clicked");
        if (listener != null) {
            listener.onClick();
        }
    }
}

class ButtonDemo {
    void demonstrate() {
        Button button = new Button("Submit");
        
        // Anonymous inner class for event handling
        button.setOnClickListener(new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Handling click event");
            }
        });
        
        button.click();
        
        // With lambda
        Button button2 = new Button("Cancel");
        button2.setOnClickListener(() -> System.out.println("Cancel clicked"));
        button2.click();
    }
}

// Iterator example with inner class
class LinkedList<T> {
    private Node<T> head;
    
    private static class Node<T> { // Static nested class
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
        }
    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Member inner class as iterator
    class LinkedListIterator {
        private Node<T> current = head;
        
        public boolean hasNext() {
            return current != null;
        }
        
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
    
    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }
}

// Builder pattern with static nested class
class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    
    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }
    
    // Static nested Builder class
    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        
        public Person build() {
            return new Person(this);
        }
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
