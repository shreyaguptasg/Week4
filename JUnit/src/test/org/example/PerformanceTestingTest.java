package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTestingTest {
    private final PerformanceTesting task = new PerformanceTesting();
    @Test
    @Timeout(5)
    void longRunningTaskTest() throws InterruptedException {
        String res = task.longRunningTask();
        assertEquals("Task completed", res,"The task did not complete as expected");
    }
}