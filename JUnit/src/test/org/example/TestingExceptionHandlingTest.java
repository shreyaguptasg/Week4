package org.example;

import org.junit.jupiter.api.Test;

import static org.example.TestingExceptionHandling.divide;
import static org.junit.jupiter.api.Assertions.*;

class TestingExceptionHandlingTest {

    @Test
    void divideTest() {
        assertEquals(3,divide(6,2));
    }
}