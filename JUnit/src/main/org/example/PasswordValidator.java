package org.example;

public class PasswordValidator {

    // Method to validate password
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        // Iterate through each character to check for uppercase and digit
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // Return true only if all conditions are met
        return hasUpperCase && hasDigit;
    }
}
