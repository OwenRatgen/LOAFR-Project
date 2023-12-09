package main;

import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.Map;

public class BatchDirectory {

    public BatchDirectory() {
    }

    public void readDirectory(String directoryPath) {

        // Create a File object for the specified directory
        File directory = new File(directoryPath);
        OptionsLoop looper = new OptionsLoop();
        ReadCsv reader = new ReadCsv();

        // Check if the specified path is a directory
        if (directoryPath.toLowerCase().endsWith(".csv")) {
            List<Map<String, String>> data = reader.read(directoryPath);
            looper.loop(data);
        } else if (directory.isDirectory()) {
            // List all CSV files in the directory
            System.out.println("This is a directory");
            System.exit(0);
            File[] csvFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

            if (csvFiles != null && csvFiles.length > 0) {
                // Iterate through each CSV file and read it
                for (File csvFile : csvFiles) {
                    System.out.println("Reading CSV file: " + csvFile.getName());

                    // Assuming CsvReader is your existing class for reading CSV file

                    /**
                     * try {
                     * reader.read("String");
                     * // Process the data as needed
                     * }
                     * /**catch (IOException e)
                     * {
                     * System.err.println("Error reading CSV file: " + e.getMessage());
                     * }
                     */
                }
            } else {
                System.out.println("No CSV files found in the specified directory.");
            }
        } else {
            System.out.println("Invalid path. Please provide a valid directory or csv file.");
        }
        return;
    }
}