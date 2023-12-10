package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OptionsLoop 
{
    public void mainLoop(List<Map<String, String>> data, String csvName) {
        Analyze analyzer = new Analyze();
        Output output = new Output();
        Scanner myScan = new Scanner(System.in);

        // new list of maps will be used if the user modifies anything during analysis
        List<Map<String, String>> modifiedList = data;

        try {
            while (true) {

                // options for the user to choose from
                System.out.println("What would you like to do with the current working dataset? Input a number from the list below.");
                System.out.println("1) See Analysis Choices");
                System.out.println("2) Output a CSV of Current Dataset");
                System.out.println("3) Print Current Dataset");
                System.out.println("4) Reset to Original Dataset");
                System.out.println("5) End Program/Next File");

                String command = myScan.nextLine();

                // call find instance based on user input which will possibly update the list to
                // only include the searched instances
                if (command.equals("1") || command.equals("1) find instances") || command.equals("find instances"))
                {
                    modifiedList = analysisOptions(data);
                }
                // print the current working set
                else if (command.equals("2") || command.equalsIgnoreCase("Output")) {
                    output.outputCsv(modifiedList, csvName);
                }
                else if (command.equals("3") || command.equalsIgnoreCase("Print")) {
                    output.printList(modifiedList);
                }
                // change the current working set back to the full set from the csv
                else if (command.equals("4") || command.equalsIgnoreCase("Reset")) {
                    modifiedList = data;
                }
                // end the program
                else if (command.equals("5") || command.equalsIgnoreCase("end program")) {
                    //myScan.close();
                    return;
                }
                // error if unrecognized input is given
                else {
                    System.out.println("*Please choose one of the listed options*");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured when trying to run main loop. Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> analysisOptions(List<Map<String, String>> data) {
        Analyze analyzer = new Analyze();
        Scanner myScan = new Scanner(System.in);

        // new list of maps will be used if the user modifies anything during analysis
        List<Map<String, String>> modifiedList = data;

        try {
            while (true) {

                // options for the user to choose from
                System.out.println("Choose a number from the following options:");
                System.out.println("1) Find Instances");
                System.out.println("2) Frequency Analysis");
                System.out.println("3) Dependency Mapping");
                System.out.println("4) Return to Main Options");

                String command = myScan.nextLine();

                // call find instance based on user input which will possibly update the list to
                // only include the searched instances
                if (command.equals("1") || command.equalsIgnoreCase("find instances")) 
                {
                    String column, keyword;
                    System.out.println("Please choose the column of data that you'd like to filter");
                    column = myScan.nextLine();
                    System.out.println("Choose the keyword/value that you're searching for in that column");
                    keyword = myScan.nextLine();

                    modifiedList = analyzer.findInstances(modifiedList, column, keyword);
                }
                else if (command.equals("2") || command.equalsIgnoreCase("frequency analysis")) 
                {
                    System.out.println("Assume the frequency analysis works");
                }
                else if (command.equals("3") || command.equalsIgnoreCase("dependency mapping")) 
                {
                    System.out.println("Assume the dependency mapping works");
                }
                else if (command.equals("4") || command.equalsIgnoreCase("Return to Main Options")) 
                {
                    return modifiedList;
                }
                // error if wrong input
                else {
                    System.out.println("*Please choose one of the listed options*");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured when trying to read in analysis option. Message: " + e.getMessage());
            e.printStackTrace();
        }
        return modifiedList;
    }
}
