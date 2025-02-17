package org.example;

public class UserRegistration {

    // Method to register a user
    public void registerUser(String username, String email, String password) {
        // Validate username (non-empty and contains only letters and numbers)
        if (username == null || username.isEmpty() || !username.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Invalid username. It must not be empty and can only contain letters and numbers.");
        }

        // Validate email (simple regex to check for valid email format)
        if (email == null || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Validate password (minimum length of 6 characters)
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }

        // Here, registration logic (e.g., saving to a database) would happen.
        System.out.println("User registered successfully!");
    }
}

