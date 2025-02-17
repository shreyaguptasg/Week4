package org.example;

import static org.example.TestingParameterized.isEven2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestingParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints={1,2,3,4})

    void isEvenTest(int number) {
        boolean expected = (number%2==0);
        boolean actual = isEven2(number);
        assertEquals(expected, actual);
    }
}