package main;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BatchDirectory {

    public BatchDirectory() {
    }

    /*
     * takes in a string to a directory, determines if it's a csv file or a
     * directory.
     * If it's a csv, run options loop normally; if it's a directory, create a list
     * of files and then run options loop for each of them
     */
    public void readDirectory(String directoryPath) {
        try {
            // Create a File object for the specified directory
            File directory = new File(directoryPath);
            OptionsLoop looper = new OptionsLoop();
            ReadCsv reader = new ReadCsv();

            // Check if the specified path is a csv file
            if (directoryPath.toLowerCase().endsWith(".csv")) {
                List<Map<String, Object>> data = reader.read(directoryPath);
                String fileName = reader.getFileName(directoryPath);
                looper.mainLoop(data, fileName);
            }
            // if not a csv, check if it's a directory
            else if (directory.isDirectory()) {
                // List all CSV files in the directory
                System.out.println("This is a directory");
                File[] csvFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

                // cycle for the csv files if the directory was not empty
                if (csvFiles != null && csvFiles.length > 0) {
                    for (File csvFile : csvFiles) {
                        System.out.println("Reading CSV file: " + csvFile.getName());

                        String csvPath = csvFile.getAbsolutePath();
                        List<Map<String, Object>> data = reader.read(csvPath);
                        String fileName = reader.getFileName(csvPath);
                        System.out.println();

                        // call main loop to allow analysis of the current csv file
                        looper.mainLoop(data, fileName);
                    }
                } else {
                    System.out.println("No CSV files found in the specified directory.");
                }
            } else {
                // Will keep asking for a valid path until the user gives one
                System.out
                        .println("Invalid path. Please provide a valid directory or csv file. Please input new path:");
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