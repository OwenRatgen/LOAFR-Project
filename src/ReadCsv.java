
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
import java.util.*;
import java.util.stream.Collectors;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
>>>>>>> 9eac3794c4589c90a382806fa44ac1661b3c6330

public class ReadCsv
{

    public static void main(String[] args)
    {

<<<<<<< HEAD
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please paste the path to your CSV file: ");

        //path to csv
        String csvFilePath = myScan.nextLine();
=======
        Analyze analyzer = new Analyze();
        Output printer = new Output();
        //path to csv, path will be path/to/csv.csv for mac
      
        String csvFilePath = "path\\to\\csv.csv";
>>>>>>> 9eac3794c4589c90a382806fa44ac1661b3c6330
        //list of maps, where each map represents a row in the csv
        List<Map<String, String>> data = read(csvFilePath);


        while(true)
        {

<<<<<<< HEAD
            List<Map<String, String>> modifiedList = data;

            System.out.println("What analysis would you like to run on this file?");
            System.out.println("Current Analysis Options:");
            System.out.println("1) Find Instances: *find all rows for which a specified column has a specified value");
            System.out.println("2) To be continued...");
            System.out.println("Type 'Print' to print the found rows");
            System.out.println("Type 'Stop' to end the program");

            String command = myScan.nextLine().toLowerCase();

            if (command.equals("1") || command.equals("1) find instances") || command.equals("find instances")) {
                String column, keyword;
                System.out.println("Please choose the column of data that you'd like to filter");
                column = myScan.nextLine().toLowerCase();
                System.out.println("Choose the keyword/value that you're searching for in that column");
                keyword = myScan.nextLine().toLowerCase();

                modifiedList = findInstances(modifiedList, column, keyword);
            }
            else if (command.equals("print")) {
                printList(modifiedList);
            }
            else if (command.equals("stop")) {
                return;
            }
            else
            {
                System.out.println("*Please choose one of the listed options*");
            }
        }

    }

    private static void printList(List<Map<String, String>> list)
    {
        for(Map<String, String> row : list)
        {
            System.out.println(row);
        }
=======
        printer.printList(data);

        //returns a list of the rows which have the desired keyword in the column "column name"
        //will need to make these strings dynamic to allow for user input in the future
        List<Map<String, String>> filteredList = analyzer.findInstances(data, "column name", "keyword");
        printer.printList(filteredList);
>>>>>>> 9eac3794c4589c90a382806fa44ac1661b3c6330
    }

    //read in the csv into a list of maps
    private static List<Map<String, String>> read(String filePath)
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
                line = line;
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
