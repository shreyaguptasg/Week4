package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    }

    @Test
    void testAddElement() {
        ListOperations.addElement(list, 5);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list, "Element should be added to the list");
    }

    @Test
    void testRemoveElement() {
        ListOperations.removeElemnet(list, 2); // Fix method name in the main class
        assertEquals(Arrays.asList(1, 2, 4), list, "Element at index 2 should be removed");
    }

    @Test
    void testGetSize() {
        assertEquals(4, ListOperations.getSize(list), "Size of the list should be 4");
    }
}
