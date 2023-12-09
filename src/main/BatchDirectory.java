package main;

import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.Map;

public class BatchDirectory 
{

    public BatchDirectory() {}

    public void readDirectory(String directoryPath) 
    {

        // Create a File object for the specified directory
        File directory = new File(directoryPath);
        OptionsLoop looper = new OptionsLoop();
        ReadCsv reader = new ReadCsv();

        // Check if the specified path is a directory
        if (directoryPath.toLowerCase().endsWith(".csv")) 
        {
            List<Map<String, String>> data = reader.read(directoryPath);
            String fileName = reader.getFileName(directoryPath);
            looper.mainLoop(data, fileName);
        } 
        else if (directory.isDirectory()) 
        {
            // List all CSV files in the directory
            System.out.println("This is a directory");
            File[] csvFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

            if (csvFiles != null && csvFiles.length > 0) 
            {
                // Iterate through each CSV file and read it
                for (File csvFile : csvFiles) {
                    System.out.println("Reading CSV file: " + csvFile.getName());

                    String csvPath = csvFile.getAbsolutePath();
                    List<Map<String, String>> data = reader.read(csvPath);
                    String fileName = reader.getFileName(csvPath);
                    looper.mainLoop(data, fileName);
                    System.out.println("Got out of first csv");
                }
            } 
            else 
            {
                System.out.println("No CSV files found in the specified directory.");
            }
        } 
        else 
        {
            System.out.println("Invalid path. Please provide a valid directory or csv file.");
        }
        return;
    }
}