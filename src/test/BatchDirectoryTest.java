package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.BatchDirectory;

public class BatchDirectoryTest {

    @Test
    public void testReadDirectoryWithCSVFile() {
        BatchDirectory batchDirectory = new BatchDirectory();

        // Specify the path to a CSV file
        String filePath = "src/test/testFiles/nonExsitantFile.csv";

        // Test readDirectory method with a single CSV file
        try {
            batchDirectory.readDirectory(filePath);
            // Add assertions or additional checks based on the expected behavior
        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    // @Test
    // public void testReadDirectoryWithDirectory() {
    //     BatchDirectory batchDirectory = new BatchDirectory();

    //     // Specify the path to a directory containing CSV files
    //     String directoryPath = "path/to/your/testdirectory";

    //     // Test readDirectory method with a directory containing CSV files
    //     try {
    //         batchDirectory.readDirectory(directoryPath);
    //         // Add assertions or additional checks based on the expected behavior
    //     } catch (Exception e) {
    //         fail("An unexpected exception occurred: " + e.getMessage());
    //     }
    // }

    // @Test
    // public void testReadDirectoryWithInvalidPath() {
    //     BatchDirectory batchDirectory = new BatchDirectory();

    //     // Specify an invalid path
    //     String invalidPath = "path/to/invalid";

    //     // Test readDirectory method with an invalid path
    //     try {
    //         batchDirectory.readDirectory(invalidPath);
    //         // Add assertions or additional checks based on the expected behavior
    //     } catch (Exception e) {
    //         // Assert that the exception is handled as expected
    //         assertTrue(e.getMessage().startsWith("Invalid path."));
    //     }
    // }

}
