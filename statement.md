# Problem Statement

Manual inventory tracking in healthcare environments (using spreadsheets or paper ledgers) is highly inefficient, prone to human error, and lacks the ability to provide real-time status updates. Errors in tracking stock can lead to critical shortages, impacting patient care and operational costs. 

The **Medicine Tracking System** provides a simple, menu-driven interface accessible via the console. This solution automates the processes of recording stock transactions and utilizes a text file for data persistence. This approach prioritizes simplicity, reliability, and a clear demonstration of core Object-Oriented programming logic over complex graphical interfaces or database management.

## Scope of the Project
The scope is limited to a local, single-user console application that manages basic inventory for a small clinic. It includes data models for medicines, basic CRUD (Create, Read, Update, Delete) operations, logic for input validation, and file-based data retention.

## Target Users
- Pharmacists in small-scale dispensaries
- Clinic administrators managing limited medical supplies
- Students learning core Java concepts (OOP, File I/O, Exceptions)

## High-Level Features
1. **Add Medicine**: Record a new medicine, its initial quantity, and expiry date.
2. **View Inventory**: Display all medicines currently in stock with their details.
3. **Update Stock**: Increment (restock) or decrement (dispense) medicine quantities.
4. **Low Stock Alerts**: Automatically check and flag items that fall below a predefined threshold.
5. **Data Persistence**: Automatically load and save inventory to a local `inventory.txt` file.
