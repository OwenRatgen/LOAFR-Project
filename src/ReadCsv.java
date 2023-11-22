
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class ReadCsv
{

    public static void main(String[] args)
    {
        Analyze analyzer = new Analyze();
        Output printer = new Output();
        ReadCsv reader = new ReadCsv();
        Scanner myScan = new Scanner(System.in);
        System.out.println("Please paste the path to your CSV file: ");


        //path to csv
        String csvFilePath = myScan.nextLine();

        int len = csvFilePath.length();

        if(csvFilePath.charAt(len-1) != 'v' || csvFilePath.charAt(len-2) != 's' || csvFilePath.charAt(len-3) != 'c' ||csvFilePath.charAt(len-4) != '.' )
        {
            System.out.println("Please input a valid csv file");
            myScan.close();
            return;
        }
        
        //list of maps, where each map represents a row in the csv
        List<Map<String, String>> data = reader.read(csvFilePath);

        List<Map<String, String>> modifiedList = data;

        while(true)
        {

            System.out.println("What analysis would you like to run on this file?");
            System.out.println("Current Analysis Options:");
            System.out.println("1) Find Instances: *find all rows for which a specified column has a specified value");
            System.out.println("2) To be continued...");
            System.out.println("Type 'Print' to print the found rows");
            System.out.println("Type 'Reset' to return to the full dataset");
            System.out.println("Type 'Stop' to end the program");

            String command = myScan.nextLine();

            if (command.equals("1") || command.equals("1) find instances") || command.equals("find instances") || command.equals("Find Instances")) {
                String column, keyword;
                System.out.println("Please choose the column of data that you'd like to filter");
                column = myScan.nextLine();
                System.out.println("Choose the keyword/value that you're searching for in that column");
                keyword = myScan.nextLine();

                modifiedList = analyzer.findInstances(modifiedList, column, keyword);
            }
            else if (command.equals("print") || command.equals("Print"))
            {
                printer.printList(modifiedList);
            }
            else if (command.equals("stop") || command.equals("Stop"))
            {
                myScan.close();
                return;
            }
            else if (command.equals("reset") || command.equals("Reset"))
            {
                modifiedList = data;
            }
            else
            {
                System.out.println("*Please choose one of the listed options*");
            }
        }

    }

    //read in the csv into a list of maps
    List<Map<String, String>> read(String filePath)
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
        }

        return data;
    }
}
