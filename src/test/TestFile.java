package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.ReadCsv;
import main.Analyze; // Import Analyze class
import main.Output; // Import Output class

public class TestFile {

    private final ReadCsv testReader = new ReadCsv();
    private final Analyze testAnalyzer = new Analyze();
    private final Output testPrinter = new Output();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final Map<String, String> testMap1 = new HashMap<String, String>();
    private final Map<String, String> testMap2 = new HashMap<String, String>();
    private final Map<String, String> testMap3 = new HashMap<String, String>();
    // Expected Lists for read() function
    private final List<Map<String, String>> expectedSingleList = new ArrayList<>();
    private final List<Map<String, String>> expectedMultipleList = new ArrayList<>();
    // Expected Lists for findInstances() function
    private final List<Map<String, String>> newExpectedSingleList = new ArrayList<>();
    private final List<Map<String, String>> newExpectedMultipleList = new ArrayList<>();
    private final List<Map<String, String>> newExpectedErrorList = new ArrayList<>();


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        testMap1.put("Test", "1");
        testMap1.put("Names", "Owen Ratgen");
        testMap1.put("Class", "CSCI 5801");
        testMap1.put("Year", "Senior");

        testMap2.put("Test", "2");
        testMap2.put("Names", "Max Percy");
        testMap2.put("Class", "CSCI 5801");
        testMap2.put("Year", "Senior");

        testMap3.put("Test", "3");
        testMap3.put("Names", "Max Percy");
        testMap3.put("Class", "CSCI 5801");
        testMap3.put("Year", "Senior");

        expectedMultipleList.add(testMap1);
        expectedMultipleList.add(testMap2);
        expectedMultipleList.add(testMap3);
        expectedSingleList.add(testMap1);

        newExpectedMultipleList.add(testMap2);
        newExpectedMultipleList.add(testMap3);
        newExpectedSingleList.add(testMap1);
    }

    // Tests the read() function in the ReadCsv Class
    @Test
    public void testSingleRead() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testSingleCsv.csv");
        Assert.assertEquals(expectedSingleList, actualList);
    }
    @Test
    public void testMultipleRead() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testMultipleCsv.csv");
        Assert.assertEquals(expectedMultipleList, actualList);
    }
    @Test
    public void testReadError() throws IOException {
        Exception exception = assertThrows(IOException.class, () -> {
            new FileReader("/bad/file/path");
        });

        String expectedMessage = "/bad/file/path (No such file or directory)";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Tests the findInstances() function in the Analyzer Class
    @Test
    public void testFindSingleInstance() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testSingleCsv.csv");
        List<Map<String, String>> newActualList = testAnalyzer.findInstances(actualList, "Names", "Owen Ratgen");
        Assert.assertEquals(newExpectedSingleList, newActualList);
    }
    @Test
    public void testFindMultipleInstances() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testMultipleCsv.csv");
        List<Map<String, String>> newActualList = testAnalyzer.findInstances(actualList, "Names", "Max Percy");
        Assert.assertEquals(newExpectedMultipleList, newActualList);
    }
    @Test
    public void testFindInstancesError() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testMultipleCsv.csv");
        List<Map<String, String>> newActualList = testAnalyzer.findInstances(actualList, "Name", "Max Percy");
        Assert.assertEquals(newExpectedErrorList, newActualList);
    }

    // Tests the printList() function in the Output Class
    @Test
    public void testSingleOutput() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testSingleCsv.csv");
        testPrinter.printList(actualList);
        String expectedString = "{Names=Owen Ratgen, Year=Senior, Test=1, Class=CSCI 5801}";
        Assert.assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }
    @Test
    public void testMultipleOutput() {
        List<Map<String, String>> actualList = testReader.read("/Users/owenratgen/Desktop/csci5801/LOAFR-Project/test/testFiles/testMultipleCsv.csv");
        testPrinter.printList(actualList);
        String expectedString = "{Names=Owen Ratgen, Year=Senior, Test=1, Class=CSCI 5801}\n{Names=Max Percy, Year=Senior, Test=2, Class=CSCI 5801}\n{Names=Max Percy, Year=Senior, Test=3, Class=CSCI 5801}";
        Assert.assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }
}
