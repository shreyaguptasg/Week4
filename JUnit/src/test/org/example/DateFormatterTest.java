package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        // Initialize the DateFormatter instance before each test
        dateFormatter = new DateFormatter();
    }

    @Test
    void testValidDate() {
        // Test a valid date in yyyy-MM-dd format
        String inputDate = "2024-02-17";
        String expected = "17-02-2024";
        assertEquals(expected, dateFormatter.formatDate(inputDate), "The date should be formatted correctly.");
    }

    @Test
    void testAnotherValidDate() {
        // Test another valid date in yyyy-MM-dd format
        String inputDate = "2023-12-31";
        String expected = "31-12-2023";
        assertEquals(expected, dateFormatter.formatDate(inputDate), "The date should be formatted correctly.");
    }

    @Test
    void testInvalidDateFormat() {
        // Test an invalid date format (not yyyy-MM-dd)
        String inputDate = "17-02-2024"; // Invalid format
        assertNull(dateFormatter.formatDate(inputDate), "The date format is invalid, and it should return null.");
    }

    @Test
    void testInvalidDate() {
        // Test an invalid date (non-existent date like 2024-02-30)
        String inputDate = "2024-02-30"; // Invalid date
        assertNull(dateFormatter.formatDate(inputDate), "The date is invalid, and it should return null.");
    }

    @Test
    void testEmptyDate() {
        // Test an empty input string
        String inputDate = "";
        assertNull(dateFormatter.formatDate(inputDate), "Empty date should return null.");
    }

    @Test
    void testNullDate() {
        // Test a null input date
        String inputDate = null;
        assertNull(dateFormatter.formatDate(inputDate), "Null date should return null.");
    }
}
