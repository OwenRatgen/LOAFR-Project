package test;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.Output;

public class OutputTest {

    @Test
    public void testPrintList() {
        Output output = new Output();

        // Test data
        List<Map<String, String>> testData = new ArrayList<>();
        Map<String, String> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", "22");
        testData.add(entry1);

        Map<String, String> entry2 = new HashMap<>();
        entry2.put("Name", "Owen");
        entry2.put("Age", "21");
        testData.add(entry2);

        // Redirect standard output to capture printed values
        System.setOut(new java.io.PrintStream(outContent));

        // Test printList method
        output.printList(testData);

        // Check if the expected output is printed
        assertEquals("{Age=22, Name=Seb}\n{Age=21, Name=Owen}\n", outContent.toString());
    }

    @Test
    public void testOutputCsv() throws IOException {
        Output output = new Output();

        // Test data
        List<Map<String, String>> testData = new ArrayList<>();
        Map<String, String> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", "22");
        testData.add(entry1);

        Map<String, String> entry2 = new HashMap<>();
        entry2.put("Name", "Owen");
        entry2.put("Age", "21");
        testData.add(entry2);

        // Test outputCsv method
        String csvName = "testOutputCsv";
        output.outputCsv(testData, csvName);
    
        // Check if the CSV file is created and has the correct content

        assertTrue(Files.exists(Paths.get("testOutpu_output.csv")));

        List<String> lines = Files.readAllLines(Paths.get("testOutpu_output.csv"));

        assertEquals("Age,Name", lines.get(0));
        assertEquals("22,Seb", lines.get(1));
        assertEquals("21,Owen", lines.get(2));

        // Clean up: delete the created CSV file
        Files.deleteIfExists(Paths.get("testOutpu_output.csv"));
    }

    // Helper variable to capture printed output
    private final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
}
