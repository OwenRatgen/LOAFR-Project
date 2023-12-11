package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.Analyze;

public class AnalyzeTest {

    @Test
    public void testFindInstances() {
        Analyze analyze = new Analyze();

        // Test data
        List<Map<String, Object>> testData = new ArrayList<>();
        Map<String, Object> entry1 = new HashMap<>();
        entry1.put("Name", "Seb");
        entry1.put("Class", "Sophomore");
        testData.add(entry1);

        Map<String, Object> entry2 = new HashMap<>();
        entry2.put("Name", "Seb");
        entry2.put("Class", "Junior");
        testData.add(entry2);

        Map<String, Object> entry3 = new HashMap<>();
        entry3.put("Name", "Owen");
        entry3.put("Class", "Senior");
        testData.add(entry3);

        // Test findInstances method
        List<Map<String, Object>> result = analyze.findInstances(testData, "Name", "Seb");

        assertEquals(2, result.size());
        assertEquals(entry1, result.get(0));
        assertEquals(entry2, result.get(1));
    }

    @Test
    public void testFrequencyAnalysis() {
        // Test data
        List<String> logEntries = new ArrayList<>();
        logEntries.add("Seb");
        logEntries.add("Max");
        logEntries.add("Owen");
        logEntries.add("Seb");
        logEntries.add("Max");

        // Test frequencyAnalysis method
        Map<String, Integer> result = Analyze.frequencyAnalysis(logEntries);

        assertEquals(2, result.get("Seb").intValue());
        assertEquals(2, result.get("Max").intValue());
        assertEquals(1, result.get("Owen").intValue());
    }

    @Test
    public void testDependencyMapping() {
        // Test data
        List<String> logEntries = new ArrayList<>();
        logEntries.add("Seb depends on Owen");
        logEntries.add("Seb depends on Max");
        logEntries.add("Owen depends on Malik");

        // Test dependencyMapping method
        Map<String, List<String>> result = Analyze.dependencyMapping(logEntries);

        assertTrue(result.containsKey("Seb"));
        assertTrue(result.containsKey("Owen"));
        assertFalse(result.containsKey("Max"));
        assertFalse(result.containsKey("Malik"));

        assertEquals(2, result.get("Seb").size());
        assertEquals(1, result.get("Owen").size());
    }

    // Add more test cases as needed for the newly added methods in Analyze class
}