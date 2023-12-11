            package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

public class Analyze {
    
    public Analyze() {}

    //creates a sublist which contains only the rows found using the header and keyword parameters
    public List<Map<String, Object>> findInstances(List<Map<String, Object>> data, String header, String keyword)
    {
        List<Map<String, Object>> newList = null;

        try {
            newList = data.stream().filter(map -> map.containsKey(header) && map.get(header).equals(keyword)).collect(Collectors.toList());

            System.out.println();
            System.out.println("Found " + newList.size() + " entries that match your search");
            System.out.println();
        } catch (Exception e) {
            System.out.println("An error occured while trying to find instance of specified data. Message: " + e.getMessage());
            e.printStackTrace();
        }

        return newList;
    }

    public List<Map<String, Object>> lessThan(List<Map<String, Object>> data, String column, double value) 
    {
        List<Map<String, Object>> filteredData = data.stream().filter(row -> 
                {
                    Object columnValue = row.get(column);

                    // Check if the column value is numeric (Double)
                    if (columnValue instanceof Double) {
                        return (Double) columnValue < value;
                    }

                    // Handle other cases, e.g., if the column value is a String
                    // Add more cases if needed based on the types you expect

                    return false; // Default case, adjust as needed
                })
                .collect(Collectors.toList());

        return filteredData;
    }

    public List<Map<String, Object>> greaterThan(List<Map<String, Object>> data, String column, double value) 
    {
        List<Map<String, Object>> filteredData = data.stream().filter(row -> 
                {
                    Object columnValue = row.get(column);

                    // Check if the column value is numeric (Double)
                    if (columnValue instanceof Double) {
                        return (Double) columnValue > value;
                    }

                    // Handle other cases, e.g., if the column value is a String
                    // Add more cases if needed based on the types you expect

                    return false; // Default case, adjust as needed
                })
                .collect(Collectors.toList());

        return filteredData;
    }

    //frequency analysis function. creates a hashMap that performs frequency analysis on a list of strings
    public static Map<String, Integer> frequencyAnalysis(List<String> logEntries) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        try {
            // Count the frequency of each unique string in the list
            for (String entry : logEntries) {
                // You may need to preprocess the entry (e.g., remove whitespace, convert to lowercase) based on your requirements
                String cleanedEntry = entry.trim();

                // Update the frequency map
                frequencyMap.put(cleanedEntry, frequencyMap.getOrDefault(cleanedEntry, 0) + 1);
            }
        } catch (Exception e) {
            System.out.println("An error occured while trying to run frequency analysis. Message: " + e.getMessage());
            e.printStackTrace();
        }

        return frequencyMap;
    }


    //basic dependency mapping function for components of log entries
    public static Map<String, List<String>> dependencyMapping(List<String> logEntries) {
        Map<String, List<String>> dependencyMap = new HashMap<>();

        try {
            // Parse log entries and extract dependencies
            for (String entry : logEntries) {
                // You need to implement a parser based on the log entry format
                // For simplicity, let's assume entries are in the format "ComponentA depends on ComponentB"
                String[] components = entry.split(" depends on ");

                if (components.length == 2) {
                    String componentA = components[0].trim();
                    String componentB = components[1].trim();

                    // Update the dependency map
                    if (dependencyMap.containsKey(componentA)) {
                        dependencyMap.get(componentA).add(componentB);
                    } else {
                        List<String> dependencies = new ArrayList<>();
                        dependencies.add(componentB);
                        dependencyMap.put(componentA, dependencies);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured when trying to run dependency mapping analysis. Message: " + e.getMessage());
            e.printStackTrace();
        }

        return dependencyMap;
    }
}