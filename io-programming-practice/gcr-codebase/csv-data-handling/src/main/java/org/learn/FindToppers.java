package org.learn;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class FindToppers {
    public static void main(String[] args) {
        try(CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/csv/students.csv"))) {
            String nextLine[];
            csvReader.readNext();
            while((nextLine = csvReader.readNext()) != null){
                if(Integer.valueOf(nextLine[3]) > 80){
                    System.out.printf("%s scored whose id is %s and age is %s scored %s%n", nextLine[1],  nextLine[0], nextLine[2], nextLine[3]);
                }
            }
        }catch (Exception e){
            System.out.printf("Error: %s\n",e.getMessage());
        }
    }
}
