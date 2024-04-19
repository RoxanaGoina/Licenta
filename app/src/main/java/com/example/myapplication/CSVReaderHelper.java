package com.example.myapplication;

import java.io.*;
import java.util.*;

public class CSVReaderHelper {
    public static void main(String[] args) {
        try {
            // Read CSV file
            BufferedReader reader = new BufferedReader(new FileReader("depression_anxiety_data.csv"));
            String line;
            List<String[]> rows = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                rows.add(values);
            }
            reader.close();

            // Print first few rows
            int numRowsToPrint = 5;
            for (int i = 0; i < numRowsToPrint && i < rows.size(); i++) {
                System.out.println(Arrays.toString(rows.get(i)));
            }

            // Length of dataframe
            System.out.println("Length of dataframe: " + rows.size());

            // Data types
            String[] firstRow = rows.get(0);
            System.out.println("Data types:");
            for (String value : firstRow) {
                if (isNumeric(value)) {
                    System.out.println("Numeric");
                } else {
                    System.out.println("String");
                }
            }

            // Column names
            System.out.println("Column names:");
            for (int i = 0; i < firstRow.length; i++) {
                System.out.println("Column " + i + ": " + firstRow[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
