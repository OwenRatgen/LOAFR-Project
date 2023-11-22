
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCsv
{

    public static void main(String[] args)
    {

        Analyze analyzer = new Analyze();
        Output printer = new Output();
        //path to csv, path will be path/to/csv.csv for mac
      
        String csvFilePath = "path\\to\\csv.csv";
        //list of maps, where each map represents a row in the csv
        List<Map<String, String>> data = readCSV(csvFilePath);

        // Display the read data
        /**for (Map<String, String> row : data)
        {
            System.out.println(row);
        }*/

        printer.printList(data);

        //returns a list of the rows which have the desired keyword in the column "column name"
        //will need to make these strings dynamic to allow for user input in the future
        List<Map<String, String>> filteredList = analyzer.findInstances(data, "column name", "keyword");
        printer.printList(filteredList);
    }

    //read in the csv into a list of maps
    private static List<Map<String, String>> readCSV(String filePath)
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
                    row.put(headers[i].trim(), values[i].trim());
                }
                //add row to the list of maps
                data.add(row);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }
}
