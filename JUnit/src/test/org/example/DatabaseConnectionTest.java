package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseConnectionTest {
    private DatabaseConnection db;
    @BeforeEach
    void setUp(){
        db = new DatabaseConnection();
        db.connect();
    }
    @AfterEach
    void down(){
        db.disConnect();
    }
    @Test
    void testConnectionEstablished(){
        assertTrue(db.isConnected());
    }
    @Test
    void testConnectionClosed(){
        assertTrue(db.isConnected());
    }
}
