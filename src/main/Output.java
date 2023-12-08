package main;

import java.util.ArrayList;
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

    public void outputCsv(List<Map<String, String>> list) {
        try {
            File newCsv = new File("output.csv");
            FileWriter writer = new FileWriter("output.csv");
            String headerString = "";
            
            for (String header : list.get(0).keySet()) {
                headerString += header + ",";
            }

            headerString = headerString.substring(0, headerString.length()-1);
            writer.write(headerString + "\n");

            for (Map<String, String> row : list) {
                String valueString = "";

                for (String val : row.values()) {
                    valueString += val + ",";
                }

                valueString = valueString.substring(0, valueString.length()-1);
                writer.write(valueString + "\n");
                        
            }

            writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
