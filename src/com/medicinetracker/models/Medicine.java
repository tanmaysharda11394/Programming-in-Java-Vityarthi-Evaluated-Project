package com.medicinetracker.models;

public class Medicine {
    private String name;
    private int quantity;
    private String expiryDate; // Format: MM/YYYY

    public Medicine(String name, int quantity, String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return String.format("Medicine: %-20s | Quantity: %-5d | Expiry: %s", name, quantity, expiryDate);
    }
}
