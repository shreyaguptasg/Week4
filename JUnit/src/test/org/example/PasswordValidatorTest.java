package org.example;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        // Initialize the PasswordValidator instance before each test
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        // Valid password meeting all criteria
        assertTrue(validator.isValid("Password1"), "Password should be valid");
    }

    @Test
    void testValidPasswordWithSpecialChars() {
        // Valid password meeting all criteria
        assertTrue(validator.isValid("Valid@123"), "Password should be valid even with special characters");
    }

    @Test
    void testShortPassword() {
        // Invalid password: less than 8 characters
        assertFalse(validator.isValid("Short1"), "Password should be invalid if it is less than 8 characters");
    }

    @Test
    void testMissingUpperCase() {
        // Invalid password: missing uppercase letter
        assertFalse(validator.isValid("password1"), "Password should be invalid if it does not contain an uppercase letter");
    }

    @Test
    void testMissingDigit() {
        // Invalid password: missing digit
        assertFalse(validator.isValid("Password"), "Password should be invalid if it does not contain a digit");
    }

    @Test
    void testNullPassword() {
        // Invalid password: null password
        assertFalse(validator.isValid(null), "Password should be invalid if it is null");
    }

    @Test
    void testEmptyPassword() {
        // Invalid password: empty password
        assertFalse(validator.isValid(""), "Password should be invalid if it is empty");
    }

    @Test
    void testPasswordWithOnlyUpperCase() {
        // Invalid password: contains only uppercase letters, no digits
        assertFalse(validator.isValid("PASSWORD"), "Password should be invalid if it contains only uppercase letters");
    }

    @Test
    void testPasswordWithOnlyDigits() {
        // Invalid password: contains only digits, no uppercase letters
        assertFalse(validator.isValid("12345678"), "Password should be invalid if it contains only digits");
    }
}
