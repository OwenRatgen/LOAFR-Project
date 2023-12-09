package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.BatchQueue;

public class BatchQueueTest {

    @Test
    public void testPrintList() {
        BatchQueue batchQueue = new BatchQueue();

        // Redirect standard output to capture printed values
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test data
        List<Map<String, String>> testData = new ArrayList<>();
        Map<String, String> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", "22");
        testData.add(entry1);

        Map<String, String> entry2 = new HashMap<>();
        entry2.put("Name", "Max");
        entry2.put("Age", "22");
        testData.add(entry2);

        // Test printList method
        batchQueue.printList(testData);

        // Check if the expected output is printed
        String expectedOutput = "{Age=22, Name=Seb}\n{Age=22, Name=Max}\n";
        assertEquals(expectedOutput, outContent.toString());

        // Clean up: restore standard output
        System.setOut(System.out);
    }
}
