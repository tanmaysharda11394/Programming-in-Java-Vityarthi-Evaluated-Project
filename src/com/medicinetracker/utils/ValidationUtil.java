package com.medicinetracker.utils;

public class ValidationUtil {

    /**
     * Validates if the given quantity is a non-negative integer.
     */
    public static boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    /**
     * Validates if the given date is in MM/YYYY format.
     */
    public static boolean isValidDate(String date) {
        if (date == null || date.length() != 7) {
            return false;
        }
        if (date.charAt(2) != '/') {
            return false;
        }
        try {
            int month = Integer.parseInt(date.substring(0, 2));
            int year = Integer.parseInt(date.substring(3));
            return month >= 1 && month <= 12 && year >= 2024;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
