package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        // Initialize the UserRegistration instance before each test
        userRegistration = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        // Test with valid username, email, and password
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser123", "valid.email@example.com", "validPass123"));
    }

    @Test
    void testInvalidUsername() {
        // Test with an invalid username (contains special characters)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("invalid@user", "valid.email@example.com", "validPass123")
        );
        assertEquals("Invalid username. It must not be empty and can only contain letters and numbers.", thrown.getMessage());
    }

    @Test
    void testInvalidEmail() {
        // Test with an invalid email (missing '@')
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("validUser123", "invalid-email.com", "validPass123")
        );
        assertEquals("Invalid email format.", thrown.getMessage());
    }

    @Test
    void testShortPassword() {
        // Test with a password shorter than 6 characters
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("validUser123", "valid.email@example.com", "short")
        );
        assertEquals("Password must be at least 6 characters long.", thrown.getMessage());
    }

    @Test
    void testEmptyUsername() {
        // Test with an empty username
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("", "valid.email@example.com", "validPass123")
        );
        assertEquals("Invalid username. It must not be empty and can only contain letters and numbers.", thrown.getMessage());
    }

    @Test
    void testEmptyEmail() {
        // Test with an empty email
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("validUser123", "", "validPass123")
        );
        assertEquals("Invalid email format.", thrown.getMessage());
    }

    @Test
    void testEmptyPassword() {
        // Test with an empty password
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userRegistration.registerUser("validUser123", "valid.email@example.com", "")
        );
        assertEquals("Password must be at least 6 characters long.", thrown.getMessage());
    }
}
