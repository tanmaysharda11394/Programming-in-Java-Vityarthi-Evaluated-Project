package com.medicinetracker;

import com.medicinetracker.exceptions.InvalidStockException;
import com.medicinetracker.services.AlertService;
import com.medicinetracker.services.InventoryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===========================================");
        System.out.println("   Welcome to Medicine Tracking System     ");
        System.out.println("===========================================");

        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. View Inventory");
            System.out.println("2. Add New Medicine");
            System.out.println("3. Update Medicine Stock");
            System.out.println("4. Check Low Stock Alerts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventoryService.displayInventory();
                    break;
                case "2":
                    System.out.print("Enter Medicine Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Quantity: ");
                    int quantity;
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }

                    System.out.print("Enter Expiry Date (MM/YYYY): ");
                    String expiryDate = scanner.nextLine();

                    inventoryService.addMedicine(name, quantity, expiryDate);
                    break;
                case "3":
                    System.out.print("Enter Medicine Name: ");
                    String updateName = scanner.nextLine();
                    
                    System.out.print("Enter quantity to add/remove (use negative for remove): ");
                    int updateQty;
                    try {
                        updateQty = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a number.");
                        break;
                    }

                    try {
                        inventoryService.updateStock(updateName, updateQty);
                    } catch (InvalidStockException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "4":
                    AlertService.checkLowStock(inventoryService.getInventory());
                    break;
                case "5":
                    System.out.println("Saving data... Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}
