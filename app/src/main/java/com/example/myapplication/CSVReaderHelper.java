package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderHelper {
    private String fileName;

    public CSVReaderHelper(String fileName) {
        this.fileName = fileName;
    }
    public CSVReaderHelper(){}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public static List<HeartRace> readHeartRateCSV(Context context, String fileName) {
//        List<HeartRace> dataList = new ArrayList<>();
//
//        try {
//            InputStream inputStream = context.getAssets().open(fileName);
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//
//            // Use the older CSVReader class
//            CSVReader csvReader = new CSVReader(inputStreamReader);
//
//
//            String[] nextLine;
//            while ((nextLine = csvReader.readNext()) != null) {
//                // Assuming the CSV format is "yyyy-MM-dd HH:mm:ssZ, heartRate"
//                if (nextLine.length >= 2) {
//                    String dateTime = nextLine[0];
//                    Integer heartRate = Integer.parseInt(nextLine[1]);  // Parse as Integer
////
////                    HeartRace heartRateData = new HeartRace(heartRate,dateTime);
////                    dataList.add(heartRateData);
////                }
////            }
////
////        } catch (IOException | NumberFormatException e) {
////            Log.e("CSVReaderHelper", "Error reading CSV file: " + e.getMessage());
////            e.printStackTrace();
////        } catch (CsvValidationException e) {
////            throw new RuntimeException(e);
////        }
////
////        return dataList;
////    }
}
