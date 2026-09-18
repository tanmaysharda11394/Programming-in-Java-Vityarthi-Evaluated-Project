# Medicine Tracking System (Java)

## Overview
A console-based Java application designed to simulate a fundamental stock management system for a small pharmacy, clinic, or medical supply unit. The core objective is to demonstrate introductory computer science principles including modular programming, data structures (Maps/Collections), exception handling, and persistent data management via file I/O.

## Features
- **Inventory Management**: Add new medicines with initial stock and expiry date.
- **Stock Updates**: Add or dispense stock.
- **Low Stock Alerts**: Identifies medicines whose current quantity is below a threshold (10 units).
- **Data Persistence**: Uses a text file (`inventory.txt`) to save and load inventory data.
- **Input Validation**: Ensures valid data entry (non-negative quantities, correct date formats).

## Technologies/Tools Used
- **Language**: Java 8+
- **Paradigm**: Object-Oriented Programming (OOP)
- **Data Persistence**: Text File I/O (`java.io.*`)

## Steps to Install & Run
1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Clone or download this repository.
3. Open a terminal/command prompt and navigate to the project directory: `cd C:\Users\tanma\OneDrive\Desktop\MedicineTrackingProject`
4. Compile the Java files: 
   ```bash
   javac -d bin src/com/medicinetracker/**/*.java src/com/medicinetracker/*.java
   ```
5. Run the application:
   ```bash
   java -cp bin com.medicinetracker.Main
   ```

## Instructions for Testing
- Run the application.
- Select Option **2** to add a new medicine (e.g., Paracetamol, 50, 12/2025).
- Select Option **1** to view the inventory.
- Select Option **3** to update the stock (e.g., enter -5 to dispense).
- Select Option **4** to check low stock alerts. (Try adding a medicine with quantity < 10 to see it triggered).
- Select Option **5** to exit, which saves data to `inventory.txt`. Restart the application and verify data is retained.
