package com.medicinetracker.utils;

import com.medicinetracker.models.Medicine;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {
    private static final String FILE_PATH = "inventory.txt";

    public static void saveInventory(Map<String, Medicine> inventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Medicine med : inventory.values()) {
                writer.write(med.getName() + "," + med.getQuantity() + "," + med.getExpiryDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    public static Map<String, Medicine> loadInventory() {
        Map<String, Medicine> inventory = new HashMap<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return inventory;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    String expiry = parts[2];
                    inventory.put(name.toLowerCase(), new Medicine(name, quantity, expiry));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading inventory from file: " + e.getMessage());
        }
        return inventory;
    }
}
