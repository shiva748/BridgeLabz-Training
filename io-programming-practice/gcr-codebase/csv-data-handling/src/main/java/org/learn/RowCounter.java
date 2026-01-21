package org.learn;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class RowCounter {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/csv/employee.csv"))) {
            String nextLine[];
            int counter = 0;
            while((nextLine = reader.readNext()) != null){
                counter++;
            };
            System.out.printf("Total number of rows: %d\n", counter-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
