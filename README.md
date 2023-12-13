# Logfile Analysis Framework Project 
-for CSCI 5801 at the University of Minnesota - Twin Cities

# Description
The current version of the loafr project has limited functionality of the whole. The project is written in Java and can read
in a logfile in the form of a CSV. This logfile is stored as a list of maps and the user has the option to perform analysis 
on the data. Currently, the analysis which is included is a findInstances feature, which allows the user to find all of the 
rows in the original data for which a specific value is found in the column specified by the user. The user can also print 
to terminal either the original data or the list of maps which contains only the rows that were kept after the user's filter.

This is only a base design for this framework, and much more functionality will be added in the near future. Some upcoming
features include:
-outputted/filtered data available in printed or file form
-batch processing so that multiple files can be uploaded and analyzed at once
-more analysis features, such as sorting, various mathematical transformations, and more filtering and searching options
-a more intuitive user access to streamline the process

# How to Install and Run
The project uses only easily available public libraries, so it is runnable on any IDE and device which have access to 
Java 17. Simply open the project from the github onto your IDE (IntelliJ was used during the development process), and 
build and run the project.

# How to Run Unit Tests
To run the unit tests in src/test/TestMain.java and run the main function Some data will be output to the terminal but if all tests pass properly you should see All tests passed: True

# How to Use the Project
When you first run the project, text will output asking you to paste the path to your csv file. You can either input the
full path to the file on your computer, or you can add a csv file to the project if your IDE allows and then just input the 
name of the file. If everything is correct, your csv file will be read into the project and you will receive another output
listing your options. These options currently are: Find Instances, Print, Reset, and Stop. Any time you are at this point
of the project, you can type stop to exit the program, print to print the current working list to the output, which at first
is the entire list of data in the csv file, or you can type reset to reset the working list to the original dataset if you've
previously modified it. The only analysis option right now is to type '1' or 'Find Instances', which takes you into the 
analysis section. This function will create a list of only the rows that contain a value you are looking for. After choosing
this option, it will ask you to specify the header for which column of the csv you are going to filter, and then you'll be 
asked to input a keyword/value that you are looking for in that column. If these are inputted correctly, you'll be looped back
to the options screen, and the working list will now only include the rows of the previous dataset for which your conditions 
were met. At this point you can print the list to see it, or filter this list another time, or reset to the original dataset, 
or stop the program.

# How to run the script
    Run the following command in your terminal:
        bash script.sh <file_path> <column_name_for_less_and_greater_than> <data_name_for_less_and_greater_than> <less_than_value> <greater_than_value> <column_name_for_find_instances> <column_name_for_find_instance>
    This script will run the "Find Instances", "Less than", and "Greater than" functions then output each file the in a output CSV file

# Credit
The developers credited with creating this project are:
- Max Percy
- Owen Ratgen
- Sebastian Hermann
- Malik Lekuti

