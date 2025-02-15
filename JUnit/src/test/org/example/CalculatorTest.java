package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    @Test
    void test() {
        Calculator c = new Calculator();
        assertEquals(17,c.add(8,9));
        assertEquals(1,c.subtract(4,3));
        assertEquals(2,c.multiply(2,1));
        assertEquals(3,c.divide(6,2));
    }
}
