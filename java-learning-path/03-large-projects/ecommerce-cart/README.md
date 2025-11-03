# E-commerce Shopping Cart System

## 📋 Project Overview

A comprehensive e-commerce shopping cart system demonstrating OOP principles, design patterns, and enterprise Java development.

## ✨ Features

- **Product Catalog:** Browse products by category
- **Shopping Cart:** Add, update, remove items
- **Order Management:** Place orders, track status
- **Payment Processing:** Multiple payment strategies
- **Discount System:** Apply coupons and promotions
- **Inventory:** Track stock levels
- **Persistence:** JSON file storage

## 🏗️ Architecture

```
ecommerce-cart/
├── model/           # Domain entities (Product, Order, Cart)
├── repository/      # Data persistence  
├── service/         # Business logic
├── payment/         # Payment strategies
└── cli/             # Command-line interface
```

## 🚀 How to Build and Run

```powershell
cd 03-large-projects\ecommerce-cart
mvn clean compile
mvn exec:java

# Run tests
mvn test
```

## 📋 Design Patterns Used

| Pattern | Usage |
|---------|-------|
| **Singleton** | CartService instance |
| **Strategy** | Payment methods |
| **Factory** | Product creation |
| **Observer** | Order status notifications |
| **Decorator** | Discount calculations |

## 🎯 Learning Goals

- Real-world e-commerce system
- Multiple design patterns
- Clean architecture
- Comprehensive testing
- JSON persistence

## 📖 Usage Examples

```java
// Create cart
ShoppingCart cart = new ShoppingCart("user123");

// Add products
cart.addItem(new Product("P001", "Laptop", 999.99), 1);
cart.addItem(new Product("P002", "Mouse", 29.99), 2);

// Apply discount
cart.applyDiscount(new PercentageDiscount(10));

// Checkout
Order order = cartService.checkout(cart, new CreditCardPayment());
```

## 🔗 Additional Resources

- Uses Gson for JSON
- Observer pattern for notifications
- Strategy pattern for payments
