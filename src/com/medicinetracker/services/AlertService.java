package com.medicinetracker.services;

import com.medicinetracker.models.Medicine;
import java.util.Map;

public class AlertService {
    private static final int LOW_STOCK_THRESHOLD = 10;

    public static void checkLowStock(Map<String, Medicine> inventory) {
        System.out.println("\n--- Low Stock Alerts (Threshold: < " + LOW_STOCK_THRESHOLD + ") ---");
        boolean foundLowStock = false;
        for (Medicine med : inventory.values()) {
            if (med.getQuantity() < LOW_STOCK_THRESHOLD) {
                System.out.println("ALERT: " + med.getName() + " is running low! Current stock: " + med.getQuantity());
                foundLowStock = true;
            }
        }
        
        if (!foundLowStock) {
            System.out.println("All medicines are sufficiently stocked.");
        }
        System.out.println("----------------------------------------\n");
    }
}
