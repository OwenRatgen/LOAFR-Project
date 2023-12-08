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

public class AnalyzeTest {
    
    @Test
    public void testCalculateSum() {
        // Create an instance of Analyze
        Analyze analyze = new Analyze();
        
        // Test the calculateSum method
        int[] numbers = {1, 2, 3, 4, 5};
        int expectedSum = 15;
        int actualSum = analyze.calculateSum(numbers);
        
        Assertions.assertEquals(expectedSum, actualSum);
    }
    
    @Test
    public void testCalculateAverage() {
        // Create an instance of Analyze
        Analyze analyze = new Analyze();
        
        // Test the calculateAverage method
        int[] numbers = {1, 2, 3, 4, 5};
        double expectedAverage = 3.0;
        double actualAverage = analyze.calculateAverage(numbers);
        
        Assertions.assertEquals(expectedAverage, actualAverage);
    }
    
    // Add more test methods for other functionalities of the Analyze class
    
}
