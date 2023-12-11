package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import main.OptionsLoop;

public class OptionsLoopTest {

    // Variable to store original System.in for restoring after tests
    private final InputStream originalSystemIn = System.in;

    @Before
    public void setUp() {
        // Set System.in to a new input stream before each test
        System.setIn(new ByteArrayInputStream("".getBytes()));
    }

    @After
    public void tearDown() {
        // Restore original System.in after each test
        System.setIn(originalSystemIn);
    }

    @Test
    public void testAnalysisOptions_FindInstances() {
        OptionsLoop optionsLoop = new OptionsLoop();
        List<Map<String, Object>> testData = createTestData();

        // Provide input for find instances
        provideInput("1\nName\nSeb\n6\n");

        List<Map<String, Object>> result = optionsLoop.analysisOptions(testData);

        // Check if findInstances method was called and modified the list
        assertEquals(1, result.size());
        assertEquals("Seb", result.get(0).get("Name"));
    }

    @Test
    public void testAnalysisOptions_ReturnToMainOptions() {
        OptionsLoop optionsLoop = new OptionsLoop();
        List<Map<String, Object>> testData = createTestData();

        // Provide input to return to main options
        provideInput("6\n");

        List<Map<String, Object>> result = optionsLoop.analysisOptions(testData);

        // Check if the list is returned unchanged
        assertEquals(testData, result);
    }

    // Helper method to set System.in for testing user input
    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private List<Map<String, Object>> createTestData() {
        List<Map<String, Object>> testData = new ArrayList<>();
        Map<String, Object> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Age", 22);
        testData.add(entry1);

        Map<String, Object> entry2 = new HashMap<>();
        entry2.put("Name", "Max");
        entry2.put("Age", 22);
        testData.add(entry2);

        return testData;
    }
}
