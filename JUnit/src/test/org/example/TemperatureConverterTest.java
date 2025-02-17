package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        // Initialize the TemperatureConverter instance before each test
        converter = new TemperatureConverter();
    }

    @Test
    void testCelsiusToFahrenheit() {
        // Test a few known values
        assertEquals(32, converter.celsiusToFahrenheit(0), "0°C should be equal to 32°F");
        assertEquals(212, converter.celsiusToFahrenheit(100), "100°C should be equal to 212°F");
        assertEquals(-40, converter.celsiusToFahrenheit(-40), "-40°C should be equal to -40°F");
    }

    @Test
    void testFahrenheitToCelsius() {
        // Test a few known values
        assertEquals(0, converter.fahrenheitToCelsius(32), "32°F should be equal to 0°C");
        assertEquals(100, converter.fahrenheitToCelsius(212), "212°F should be equal to 100°C");
        assertEquals(-40, converter.fahrenheitToCelsius(-40), "-40°F should be equal to -40°C");
    }

    @Test
    void testCelsiusToFahrenheitWithNegativeValue() {
        // Test a negative Celsius value
        assertEquals(-22, converter.celsiusToFahrenheit(-30), "-30°C should be equal to -22°F");
    }

    @Test
    void testFahrenheitToCelsiusWithNegativeValue() {
        // Test a negative Fahrenheit value
        assertEquals(-18.8889, converter.fahrenheitToCelsius(-2), 0.0001, "-2°F should be equal to -18.8889°C");
    }

    @Test
    void testCelsiusToFahrenheitWithDecimal() {
        // Test Celsius value with decimal points
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.1, "37°C should be equal to 98.6°F");
    }

    @Test
    void testFahrenheitToCelsiusWithDecimal() {
        // Test Fahrenheit value with decimal points
        assertEquals(37, converter.fahrenheitToCelsius(98.6), 0.1, "98.6°F should be equal to 37°C");
    }
}
