package com.example.javaguide.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class SolidPrinciplesTest {

    @Test
    @DisplayName("SRP: Invoice should only hold data")
    void testInvoice() {
        Invoice invoice = new Invoice("INV-001", 100.0);
        assertEquals("INV-001", invoice.getId());
        assertEquals(100.0, invoice.getAmount());
    }

    @Test
    @DisplayName("OCP: AreaCalculator works with any shape")
    void testOCP() {
        AreaCalculator calc = new AreaCalculator();
        assertEquals(Math.PI * 25, calc.calculate(new AreaCircle(5.0)), 0.001);
        assertEquals(24.0, calc.calculate(new AreaRectangle(4.0, 6.0)), 0.001);
        assertEquals(6.0, calc.calculate(new AreaTriangle(3.0, 4.0)), 0.001);
    }

    @Test
    @DisplayName("LSP: Sparrow is Flyable, Penguin is not")
    void testLSP() {
        LspBird sparrow = new Sparrow();
        LspBird penguin = new Penguin();

        assertInstanceOf(Flyable.class, sparrow);
        assertFalse(penguin instanceof Flyable);
    }

    @Test
    @DisplayName("DIP: NotificationService works with any MessageSender")
    void testDIP() {
        assertDoesNotThrow(() -> {
            NotificationService service = new NotificationService(new EmailSender());
            service.sendNotification("test");
        });
    }

    @Test
    @DisplayName("Main method should run without errors")
    void testMainRuns() {
        assertDoesNotThrow(() -> SolidPrinciplesDemo.main(new String[]{}));
    }
}
