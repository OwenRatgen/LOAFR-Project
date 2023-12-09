package main;

import java.util.Scanner;

public class RunLoafr {
    public static void main(String[] args) {

        try {
            // create new objects to perform different functions
            BatchDirectory directory = new BatchDirectory();
            Scanner myScan = new Scanner(System.in);

            System.out.println("Please paste the path to your CSV file or directory containing you csv file(s): ");

            // csv file or the path to csv file
            String csvFilePath = myScan.nextLine();

            directory.readDirectory(csvFilePath);

            myScan.close();
        } catch (Exception e) {
            System.out.println("An error occured when trying to initially run loafr software. Message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
