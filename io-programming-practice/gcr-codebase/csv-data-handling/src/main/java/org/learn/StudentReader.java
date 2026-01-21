package org.learn;
import com.opencsv.CSVReader;

import java.io.FileReader;

public class StudentReader {
    public static void main(String[] args) {
        try(CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/csv/students.csv"))) {
            String[] nextLine;
            while((nextLine = csvReader.readNext()) != null){
                System.out.println(nextLine[0]+" "+nextLine[1]+" "+nextLine[2]+" "+nextLine[3]);
            }
        } catch (Exception e) {
            System.out.printf("Error: %s\n",e.getMessage());
        }
    }
}
