package com.medicinetracker.services;

import com.medicinetracker.exceptions.InvalidStockException;
import com.medicinetracker.models.Medicine;
import com.medicinetracker.utils.FileUtil;
import com.medicinetracker.utils.ValidationUtil;

import java.util.Map;

public class InventoryService {
    private Map<String, Medicine> inventory;

    public InventoryService() {
        this.inventory = FileUtil.loadInventory();
    }

    public void addMedicine(String name, int quantity, String expiryDate) {
        if (!ValidationUtil.isValidQuantity(quantity)) {
            System.out.println("Error: Quantity must be non-negative.");
            return;
        }
        if (!ValidationUtil.isValidDate(expiryDate)) {
            System.out.println("Error: Invalid date format. Use MM/YYYY.");
            return;
        }

        String key = name.toLowerCase();
        if (inventory.containsKey(key)) {
            System.out.println("Medicine already exists. Use the update option to modify stock.");
        } else {
            inventory.put(key, new Medicine(name, quantity, expiryDate));
            FileUtil.saveInventory(inventory);
            System.out.println("Medicine added successfully.");
        }
    }

    public void updateStock(String name, int quantityToAddOrRemove) throws InvalidStockException {
        String key = name.toLowerCase();
        if (!inventory.containsKey(key)) {
            System.out.println("Medicine not found in inventory.");
            return;
        }

        Medicine med = inventory.get(key);
        int newQuantity = med.getQuantity() + quantityToAddOrRemove;

        if (newQuantity < 0) {
            throw new InvalidStockException("Cannot remove more stock than currently available. Current stock: " + med.getQuantity());
        }

        med.setQuantity(newQuantity);
        FileUtil.saveInventory(inventory);
        System.out.println("Stock updated successfully. New quantity: " + newQuantity);
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("--- Current Inventory ---");
        for (Medicine med : inventory.values()) {
            System.out.println(med);
        }
        System.out.println("-------------------------");
    }

    public Map<String, Medicine> getInventory() {
        return inventory;
    }
}
