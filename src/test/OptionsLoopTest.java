package test;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import main.OptionsLoop;

public class OptionsLoopTest {

    // Tests for input 2 and 3 are tested in seperate file because relate more to Output.java 
    // rather than Options loop so makes more sense to test elsewhere

    @Test
    public void testAnalysisOptions_FindInstances() {
        OptionsLoop optionsLoop = new OptionsLoop();
        List<Map<String, String>> testData = createTestData();

        // Provide input for find instances
        provideInput("1\nName\nSeb\n4\n");

        List<Map<String, String>> result = optionsLoop.analysisOptions(testData);

        // Check if findInstances method was called and modified the list
        assertEquals(1, result.size());
        assertEquals("Seb", result.get(0).get("Name"));
    }

    @Test
    public void testAnalysisOptions_ReturnToMainOptions() {
        OptionsLoop optionsLoop = new OptionsLoop();
        List<Map<String, String>> testData = createTestData();

        // Provide input to return to main options
        provideInput("4\n");

        List<Map<String, String>> result = optionsLoop.analysisOptions(testData);

        // Check if the list is returned unchanged
        assertEquals(testData, result);
    }

    // Helper method to set System.in for testing user input
    private void provideInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private List<Map<String, String>> createTestData() {
        List<Map<String, String>> testData = new ArrayList<>();
        Map<String, String> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", "22");
        testData.add(entry1);

        Map<String, String> entry2 = new HashMap<>();
        entry2.put("Name", "Max");
        entry2.put("Age", "22");
        testData.add(entry2);

        return testData;
    }

    // Variable to store original System.in for restoring after tests
    private final InputStream stdin = System.in;
}