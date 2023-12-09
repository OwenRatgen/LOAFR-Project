package main;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Output {
    
    public Output() {}

    public void printList(List<Map<String, String>> list)
    {
        for(Map<String, String> row : list)
        {
            System.out.println(row);
        }
    }

    public void outputCsv(List<Map<String, String>> list, String csvName)
    {
        try {
            csvName = csvName.substring(0, csvName.length()-4);

            // Creates the new CSV file and sets up the writer for the file
            File newCsv = new File(csvName + "output.csv");
            FileWriter writer = new FileWriter(csvName + "_output.csv");
            String headerString = "";
            
            // Gets all of the column headers and adds them to a string
            for (String header : list.get(0).keySet()) {
                headerString += header + ",";
            }

            // Gets rid of the last comma along with writing the columns into the CSV file
            headerString = headerString.substring(0, headerString.length()-1);
            writer.write(headerString + "\n");

            // Gets each row's value and inputs it in the file
            for (Map<String, String> row : list) {
                String valueString = "";

                for (String val : row.values()) {
                    valueString += val + ",";
                }

                valueString = valueString.substring(0, valueString.length()-1);
                writer.write(valueString + "\n");
                        
            }

            writer.close();

        // Used for any unexpected IO errors
        } catch (IOException e) {
            System.out.println("An error while producing new CSV file occured. Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
