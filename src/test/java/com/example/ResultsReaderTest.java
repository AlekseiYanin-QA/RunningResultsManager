package com.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ResultsReaderTest {

    private ResultsReader reader;
    private ResultParser mockParser;

    @BeforeEach
    void setUp() {
        mockParser = new ResultParser();
        reader = new ResultsReader(mockParser);
    }

    @Test
    void testReadFromFile() throws Exception {
        Path filePath = Paths.get("src/test/resources/results.txt");
        List<Result> results = reader.readFromFile(filePath);

        assertNotNull(results);
        assertEquals(2, results.size());
    }

    @Test
    void testReadFromNonExistentFile() {
        Path nonExistentFilePath = Paths.get("nonexistent_file.txt");
        assertThrows(UncheckedIOException.class, () -> reader.readFromFile(nonExistentFilePath));
    }
}