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
            e.printStackTrace();
            return null;
        }

        return data;
    }

    public String getFileName(String filePath)
    {
        int lastSeparatorIndex = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));
        String fileName = filePath.substring(lastSeparatorIndex + 1);
        
        return fileName;
        
    }
}
