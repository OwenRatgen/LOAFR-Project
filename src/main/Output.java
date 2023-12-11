package main;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Output {

    public Output() {
    }

    public void printList(List<Map<String, Object>> list) {
        for (Map<String, Object> row : list) {
            System.out.println(row);
        }
    }

    public void outputCsv(List<Map<String, Object>> list, String csvName) {
        try {
            csvName = csvName.substring(0, csvName.length() - 4);

            // Creates the new CSV file and sets up the writer for the file
            File newCsv = new File(csvName + "output.csv");
            FileWriter writer = new FileWriter(csvName + "_output.csv");
            String headerString = "";

            // Gets all of the column headers and adds them to a string
            for (String header : list.get(0).keySet()) {
                headerString += header + ",";
            }

            // Gets rid of the last comma along with writing the columns into the CSV file
            headerString = headerString.substring(0, headerString.length() - 1);
            writer.write(headerString + "\n");

            // Gets each row's value and inputs it in the file
            for (Map<String, Object> row : list) {
                String valueString = "";

                for (Object val : row.values()) {
                    String stringValue = val.toString();
                    valueString += stringValue + ",";
                }

                valueString = valueString.substring(0, valueString.length() - 1);
                writer.write(valueString + "\n");

            }

            writer.close();

            // Used for any unexpected IO errors
        } catch (IOException e) {
            System.out.println("An error while producing new CSV file occured. Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void outputEntryCount(List<Map<String, Object>> list, String csvName) {
        try {
            csvName = csvName.substring(0, csvName.length() - 4);

            // Creates the new text file and sets up the writer for the file
            File newTextFile = new File(csvName + "_num_found.txt");
            FileWriter writer = new FileWriter(newTextFile);

            // Writes the count of entries to the text file
            writer.write("Number of entries: " + list.size() + "\n");

            writer.close();

            // Used for any unexpected IO errors
        } catch (IOException e) {
            System.out.println("An error while producing entry count file occurred. Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
