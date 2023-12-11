package main;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BatchDirectory 
{

    public BatchDirectory() {}

    public void readDirectory(String directoryPath) 
    {
        try {
            // Create a File object for the specified directory
            File directory = new File(directoryPath);
            OptionsLoop looper = new OptionsLoop();
            ReadCsv reader = new ReadCsv();

            // Check if the specified path is a directory
            if (directoryPath.toLowerCase().endsWith(".csv")) 
            {
                List<Map<String, Object>> data = reader.read(directoryPath);
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
                    for (File csvFile : csvFiles) {
                        System.out.println("Reading CSV file: " + csvFile.getName());

                        String csvPath = csvFile.getAbsolutePath();
                        List<Map<String, Object>> data = reader.read(csvPath);
                        String fileName = reader.getFileName(csvPath);
                        System.out.println();
                        looper.mainLoop(data, fileName);
                    }
                } 
                else 
                {
                    System.out.println("No CSV files found in the specified directory.");
                }
            } 
            else 
            {
                // Will keep asking for a valid path until the user gives one
                System.out.println("Invalid path. Please provide a valid directory or csv file. Please input new path:");
                Scanner myScan = new Scanner(System.in);
                String csvFilePath = myScan.nextLine();
                readDirectory(csvFilePath);
                myScan.close();
            }
        } catch (Exception e) {
            System.out.println("An error occured when trying to read the directory. Message: " + e.getMessage());
            e.printStackTrace();
        }
        return;
    }
}