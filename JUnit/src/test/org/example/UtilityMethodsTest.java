package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityMethodsTest {

    @Test
    void reverse() {
        UtilityMethods um = new UtilityMethods();
        assertEquals("avaj", um.reverse("java"));
    }

    @Test
    void isPalindrome() {
        UtilityMethods um = new UtilityMethods();
        assertEquals(false,um.isPalindrome("java"));
    }

    @Test
    void toUpperCase() {
        UtilityMethods um = new UtilityMethods();
        assertEquals("JAVA",um.toUpperCase("java"));
    }
}