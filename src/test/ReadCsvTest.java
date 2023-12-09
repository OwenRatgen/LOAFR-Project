package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.ReadCsv;


public class ReadCsvTest {

    @Test
    public void testRead() {
        ReadCsv readCsv = new ReadCsv();

        // Test data
        String filePath = "src/test/testFiles/testMultipleCsv.csv";

        // Test read method
        List<Map<String, String>> result = readCsv.read(filePath);

        // Check if the data is read correctly
        assertEquals(3, result.size());

        Map<String, String> row1 = result.get(0);
        assertEquals("1", row1.get("Test"));
        assertEquals("Owen Ratgen", row1.get("Name"));
        assertEquals("CSCI 5801", row1.get("Class"));
        assertEquals("Senior", row1.get("Year"));

        Map<String, String> row2 = result.get(1);
        assertEquals("2", row2.get("Test"));
        assertEquals("Max Percy", row2.get("Name"));
        assertEquals("CSCI 5801", row2.get("Class"));
        assertEquals("Senior", row2.get("Year"));

        Map<String, String> row3 = result.get(2);
        assertEquals("3", row3.get("Test"));
        assertEquals("Sebastian Hermann", row3.get("Name"));
        assertEquals("CSCI 5801", row3.get("Class"));
        assertEquals("Senior", row3.get("Year"));
    }

    @Test
    public void testGetFileName() {
        ReadCsv readCsv = new ReadCsv();

        // Test data
        String filePath = "src/test/testFiles/testMultipleCsv.csv";

        // Test getFileName method
        String result = readCsv.getFileName(filePath);

        // Check if the file name is extracted correctly
        assertEquals("testMultipleCsv.csv", result);
    }

    @Test
    public void testGetFileNameWithPathContainingSpaces() {
        ReadCsv readCsv = new ReadCsv();

        // Test data with spaces in the file path
        String filePath = "src /test /testFiles/testMultipleCsv.csv";

        // Test getFileName method with spaces in the file path
        String result = readCsv.getFileName(filePath);

        // Check if the file name is extracted correctly
        assertEquals("testMultipleCsv.csv", result);
    }

    @Test
    public void testNonexistentFile() {
        ReadCsv readCsv = new ReadCsv();

        // Test data with a nonexistent file
        String filePath = "nonexistent_file.csv";

        // Test read method with a nonexistent file
        List<Map<String, String>> result = readCsv.read(filePath);

        // Check if the result is an empty list
        assertTrue(result.isEmpty());
    }
}