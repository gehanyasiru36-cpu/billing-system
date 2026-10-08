# Fruit Shop Billing System

A Java Swing desktop point-of-sale (POS) application for a fruit shop, backed by a MySQL database.

## Tech Stack
- **Language:** Java 17
- **UI:** Java Swing
- **Database:** MySQL (JDBC)
- **Build tool:** Maven

## Features
- Login screen with role-based users (Admin / Cashier)
- Dashboard with sidebar navigation and summary cards
- Product list loaded from the database
- POS billing screen: add items, remove items, live total calculation

## Planned / In Progress
- Save completed sales to the database (`sales` and `sale_items` tables are ready)
- Customers, Suppliers, Sales Reports and User management screens
- Live dashboard figures (today's sales, low stock, customers)
- Password hashing

## Getting Started

### Prerequisites
- JDK 17 or later
- Apache Maven
- MySQL Server

### 1. Set up the database
Run the script in `src/main/resources/database.sql` in MySQL. It creates the `fruit_shop` database, all tables and some sample data (users and products).

### 2. Configure the connection
Open `src/main/java/com/fruitshop/config/DBConnection.java` and set your MySQL username and password.

### 3. Build and run
```bash
git clone https://github.com/gehanyasiru36-cpu/billing-system.git
cd billing-system
mvn clean package
java -jar target/BillingSystem.jar
```

## Project Structure
```
src/main/java/com/fruitshop/
├── Main.java
├── config/   DBConnection.java
├── dao/      ProductDAO.java, UserDAO.java
├── model/    Product.java, User.java
└── ui/       LoginFrame.java, DashboardFrame.java, BillingFrame.java
src/main/resources/database.sql
```

## Note
This is a learning project. The sample users in `database.sql` use plain-text passwords and are for demonstration only. Change them before any real use.

## Author
**Gehan Yasiru Rashmitha**
[LinkedIn](https://www.linkedin.com/in/gehan-yasiru-923b36353) | [GitHub](https://github.com/gehanyasiru36-cpu)
