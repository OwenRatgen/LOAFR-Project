import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RunLoafr
{
    public static void main(String[] args)
    {
        //create new objects to perform different functions
        Analyze analyzer = new Analyze();
        Output printer = new Output();
        ReadCsv reader = new ReadCsv();
        Scanner myScan = new Scanner(System.in);


        System.out.println("Please paste the path to your CSV file: ");

        //csv file or the path to csv file
        String csvFilePath = myScan.nextLine();

        //make sure that the file is a csv format
        int len = csvFilePath.length();
        if(csvFilePath.charAt(len-1) != 'v' || csvFilePath.charAt(len-2) != 's' || csvFilePath.charAt(len-3) != 'c' ||csvFilePath.charAt(len-4) != '.' )
        {
            System.out.println("Please input a valid csv file");
            myScan.close();
            return;
        }

        //calls the read function to create a list of maps, where each map represents a row in the csv
        List<Map<String, String>> data = reader.read(csvFilePath);

        //new list of maps will be used if the user modifies anything during analysis
        List<Map<String, String>> modifiedList = data;

        //loop options for the user until they choose stop
        while(true)
        {
            //options for the user to choose from
            System.out.println("What analysis would you like to run on this file?");
            System.out.println("Current Analysis Options:");
            System.out.println("1) Find Instances: *find all rows for which a specified column has a specified value");
            System.out.println("2) To be continued...");
            System.out.println("Type 'Print' to print the found rows");
            System.out.println("Type 'Reset' to return to the full dataset");
            System.out.println("Type 'Stop' to end the program");

            String command = myScan.nextLine();

            //call find instance based on user input which will possibly update the list to only include the searched instances
            if (command.equals("1") || command.equals("1) find instances") || command.equals("find instances") || command.equals("Find Instances")) {
                String column, keyword;
                System.out.println("Please choose the column of data that you'd like to filter");
                column = myScan.nextLine();
                System.out.println("Choose the keyword/value that you're searching for in that column");
                keyword = myScan.nextLine();

                modifiedList = analyzer.findInstances(modifiedList, column, keyword);
            }
            //print the current working set
            else if (command.equals("print") || command.equals("Print"))
            {
                // printer.printList(modifiedList);
                printer.outputCsv(modifiedList);
            }
            //end the program
            else if (command.equals("stop") || command.equals("Stop"))
            {
                myScan.close();
                return;
            }
            //change the current working set back to the full set from the csv
            else if (command.equals("reset") || command.equals("Reset"))
            {
                modifiedList = data;
            }
            //error if unrecognized input is given
            else
            {
                System.out.println("*Please choose one of the listed options*");
            }
        }
    }
}
