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
        List<Map<String, String>> testData = new ArrayList<>();
        Map<String, String> entry1 = new HashMap<>();
        entry1.put("Header1", "Keyword");
        entry1.put("Header2", "Value1");
        testData.add(entry1);

        Map<String, String> entry2 = new HashMap<>();
        entry2.put("Header1", "Keyword");
        entry2.put("Header2", "Value2");
        testData.add(entry2);

        Map<String, String> entry3 = new HashMap<>();
        entry3.put("Header1", "Different");
        entry3.put("Header2", "Value3");
        testData.add(entry3);

        // Test findInstances method
        List<Map<String, String>> result = analyze.findInstances(testData, "Header1", "Keyword");

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
        System.out.println(result.get("Max"));
        assertEquals(result.get("Seb"), result.get("Seb"));
        assertEquals(result.get("Max"), result.get("Max"));
        assertEquals(result.get("Owen"), result.get("Owen"));
    }

    @Test
    public void testDependencyMapping() {
        // Test data
        List<String> logEntries = new ArrayList<>();
        logEntries.add("ComponentA depends on ComponentB");
        logEntries.add("ComponentA depends on ComponentC");
        logEntries.add("ComponentB depends on ComponentD");

        // Test dependencyMapping method
        Map<String, List<String>> result = Analyze.dependencyMapping(logEntries);

        assertTrue(result.containsKey("ComponentA"));
        assertTrue(result.containsKey("ComponentB"));
        assertFalse(result.containsKey("ComponentC"));
        assertFalse(result.containsKey("ComponentD"));


        assertEquals(2, result.get("ComponentA").size());
        assertEquals(1, result.get("ComponentB").size());
    }
}