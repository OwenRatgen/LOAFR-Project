package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class ReadCsv
{
    public ReadCsv() {}

    //read in the csv into a list of maps
    public List<Map<String, String>> read(String filePath)
    {
        List<Map<String, String>> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            // Read the header
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] values = line.split(",");
                //hash map to represent each row
                Map<String, String> row = new HashMap<>();

                //add each value along with its header
                for (int i = 0; i < Math.min(headers.length, values.length); i++)
                {
                    headers[i] = Normalizer.normalize(headers[i], Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
                    row.put(headers[i].trim(), values[i].trim());
                }
                //add row to the list of maps
                data.add(row);
            }

        } catch (IOException e)
        {
            System.out.println("An error occured when trying to read in the given CSV file. Message: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }

    public String getFileName(String filePath)
    {
        String fileName = "";
        try {
            int lastSeparatorIndex = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));
            fileName = filePath.substring(lastSeparatorIndex + 1);
        } catch (Exception e) {
            System.out.println("An error occured when trying to access the file name. Message: ");
            // Checks to see if error has a message
            if (e.getMessage() != null) {
                System.out.println(e.getMessage());
            }
            e.printStackTrace();
        }
        
        return fileName;
        
    }
}
