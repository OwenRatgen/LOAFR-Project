package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Output;

public class OutputTest {

    // Helper variable to capture printed output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Variable to store original System.out for restoring after tests
    private final PrintStream originalSystemOut = System.out;

    @Before
    public void setUp() {
        // Redirect standard output to capture printed values
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        // Restore original System.out after each test
        System.setOut(originalSystemOut);
        // Clean up: close the ByteArrayOutputStream
        outContent.reset();
    }

    @Test
    public void testPrintList() {
        Output output = new Output();

        // Test data
        List<Map<String, Object>> testData = createTestData();

        // Test printList method
        output.printList(testData);

        // Check if the expected output is printed
        assertEquals("{Age=22, Name=Seb}\n{Age=22, Name=Owen}\n", outContent.toString());
    }

    @Test
    public void testOutputCsv() throws IOException {
        Output output = new Output();

        // Test data
        List<Map<String, Object>> testData = createTestData();

        // Test outputCsv method
        String csvName = "testOutputCsv";
        output.outputCsv(testData, csvName);

        // Check if the CSV file is created and has the correct content
        assertTrue(Files.exists(Paths.get("testOutpu_output.csv")));

        List<String> lines = Files.readAllLines(Paths.get("testOutpu_output.csv"));

        assertEquals("Age,Name", lines.get(0));
        assertEquals("22,Seb", lines.get(1));
        assertEquals("22,Owen", lines.get(2));

        // Clean up: delete the created CSV file
        Files.deleteIfExists(Paths.get("testOutpu_output.csv"));
    }

    // Helper method to create test data
    private List<Map<String, Object>> createTestData() {
        List<Map<String, Object>> testData = new ArrayList<>();
        Map<String, Object> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", 22);
        testData.add(entry1);

        Map<String, Object> entry2 = new HashMap<>();
        entry2.put("Name", "Owen");
        entry2.put("Age", 22);
        testData.add(entry2);

        return testData;
    }
}