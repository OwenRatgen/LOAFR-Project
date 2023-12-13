# Logfile Analysis Framework Project 
-for CSCI 5801 at the University of Minnesota - Twin Cities

# Description
The project is written in Java and can readin a logfile in the form of a CSV. This logfile is stored as a list of maps and 
the user has the option to perform analysis on the data. Currently, the analyses which are included are: a findInstances 
feature, which allows the user to find all of the rows in the original data for which a specific value is found in the 
column specified by the user, a greaterThan feature which returns all entries that contain a value greater than the inputted
value in the chosen column, a lessThan feature that does the same thing except for values less than the inputted value, and 
dependency mapping and frequency analysis features that don't have a method to output yet, but will be added in the near 
future. The user can print to terminal or output in a CSV file either the original data or the list of maps which contains 
only the rows that were kept after the user's filtering. Loafr supports batch processing and individual manual processing.

This is a start for the design for this framework, and much more functionality will be added in the future. Some 
upcoming features will include:
-more analysis features
-a more intuitive user access to streamline the process

# How to Install and Run
The project uses only easily available public libraries, so it is runnable on any device which have access to 
Java 17. Simply unzip the project, and then from the directory where it is located, run "java -jar LOAFR-Project.jar"
in the terminal to run the project manually, or follow the instructions in the "Script and How to Run" section
to run the provided script

# How to Run Unit Tests
To run the unit tests: enter src/test/TestMain.java and run the main function. Some data will be output to the terminal but if all tests pass properly you should see All tests passed: True

# How to Use the Project
If you'd like to do manual analysis, run RunLoafr.java by typing "java -jar LOAFR-Project.jar" from the terminal while inside the 
LOAFR-Project directory. Text will output asking you to paste the path to your csv file or directory of csv files. You can either input the
full path to the file/directory on your computer, or you can add a csv file/directory to the project and input "./name_of_file.csv". If everything is correct, your csv file will be read into the project and you will receive another output
listing your options. If a directory was input, the following instructions apply for the first csv in the directory, and selecting the number 5 will take you to the next file in the directory until there are none left. For each file, in the options loop, the choices are: 
See Analysis Choices, Output a CSV, Print, Reset, End Program, and Output # of Entries. Any time you are at this point
of the system, you can type 5 to exit the program/go to next file, 6 to output the current number of entries to a text file, 2 to output 
the current set in a csv file, or 3 to print the current working list to the output, which at first
is the entire list of data in the csv file, or you can type 4 to reset the working list to the original dataset if you've
previously modified it. Typing 1 takes you into the analysis options loop where you can choose how to process the dataset. In this loop, the first option is to type 1 for 'Find Instances', which will create a list of only the rows that contain a value you are looking for. After choosing
this option, it will ask you to specify the header for which column of the csv you are going to filter, and then you'll be 
asked to input a keyword/value that you are looking for in that column. If these are inputted correctly, you'll be looped back
to the analysis options loop, and the working list will now only include the rows of the previous dataset for which your conditions 
were met. Other analysis options are less than and greater than, which ask for column and input parameters like findInstances but instead only include entries for which the value in the specified column is greater than or less than the inputted value, depending on which you choose. Frequency Analysis and Dependency Mapping are currently being worked on, and so have no method to output at the moment. At any point that the analysis loop is open, you can type 6 to return to the main options loop to output or reset the current working set, or exit the program.

# Script and How to Run
    script.sh is included as a method to run a specific batch processing analysis for this program. The user inputs a directory that contains any number of csv files, along with the parameters they want to analyze by. This script will find every entry of a csv file which belongs to a certain category(using findInstances) and for which a value in a column of your choosing is within a certain range (using lessThan and greaterThan). The results for each csv file will be output in "name_of_file_output.csv" in the project directory.
    
    Run the following command in your terminal (for mac do bash script.sh, for windows do ./script.sh):
        bash script.sh <file_path> <column_name_for_less_and_greater_than> <less_than_value> <greater_than_value> <column_name_for_find_instances> <data_name_for_find_instances>
        OR
        ./script.sh <file_path> <column_name_for_less_and_greater_than> <less_than_value> <greater_than_value> <column_name_for_find_instances> <data_name_for_find_instances>
    This script will run the "Find Instances", "Less than", and "Greater than" functions then output each file the in a output CSV file

# Credit
The developers credited with creating this project are:
- Max Percy
- Owen Ratgen
- Sebastian Hermann
- Malik Lekuti

