package org.example;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private FileProcessor fileProcessor;
    private String testFileName = "testFile.txt";

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() {
        try {
            Files.deleteIfExists(Paths.get(testFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWriteAndReadContent() {
        String contentToWrite = "Hello, World!";
        try {
            // Write content to the file
            fileProcessor.writeToFile(testFileName, contentToWrite);

            // Read content from the file
            String contentRead = fileProcessor.readFromFile(testFileName);

            // Assert that the written and read content are the same
            assertEquals(contentToWrite, contentRead);
        } catch (IOException e) {
            fail("IOException occurred while writing/reading the file.");
        }
    }

    @Test
    void testFileExistsAfterWrite() {
        String contentToWrite = "This is a test.";
        try {
            // Write content to the file
            fileProcessor.writeToFile(testFileName, contentToWrite);

            // Assert that the file exists after writing
            assertTrue(fileProcessor.fileExists(testFileName));
        } catch (IOException e) {
            fail("IOException occurred while writing the file.");
        }
    }

    @Test
    void testIOExceptionWhenFileDoesNotExist() {
        String nonExistentFile = "nonExistentFile.txt";
        try {
            // Try reading from a non-existent file
            fileProcessor.readFromFile(nonExistentFile);
            fail("Expected IOException when trying to read from a non-existent file.");
        } catch (IOException e) {
            // Expected exception
            assertTrue(e instanceof IOException);
        }
    }
}























































