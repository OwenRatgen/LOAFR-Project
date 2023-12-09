package test;

// import static org.junit.Assert.*;


// import java.io.ByteArrayInputStream;
// import java.io.InputStream;
// import java.util.List;

// import java.util.Map;
// import java.util.Scanner;

// import org.junit.Test;
// import org.junit.Before;
// import main.RunLoafr;
// import main.BatchDirectory;

public class RunLoafrTest {

//     private final RunLoafr runLoafr = new RunLoafr();
//     private final BatchDirectory batchDirectory = new BatchDirectory();

//     // Helper method to set System.in for testing user input
//     private void provideInput(String data) {
//         InputStream stdin = System.in;
//         System.setIn(new ByteArrayInputStream(data.getBytes()));
//         Scanner myScan = new Scanner(System.in);
//     }

//     // Helper method to restore System.in after testing user input
//     private void restoreInput() {
//         System.setIn(stdin);
//         myScan.close();
//     }

//     @Before
//     public void setUp() {
//         // Any setup needed before tests
//     }

//     @Test
//     public void testRunLoafrWithCSVFile() {
//         // Provide input for the path to a CSV file
//         provideInput("src/test/testFiles/testMultipleCsv.csv");

//         // Call the main method
//         RunLoafr.main(null);

//         // Restore System.in
//         restoreInput();

//         // You may want to add assertions based on the expected behavior
//     }

//     @Test
//     public void testRunLoafrWithDirectory() {
//         // Provide input for the path to a directory
//         provideInput("src/test/testFiles");

//         // Call the main method
//         RunLoafr.main(null);

//         // Restore System.in
//         restoreInput();

//         // You may want to add assertions based on the expected behavior
//     }
}
