package org.learn;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/csv/employee.csv"))){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the name of the employee you want to search: ");
            String name = sc.nextLine();
            sc.close();
            String nextLine[];
            while ((nextLine = reader.readNext()) != null) {
                if(nextLine[1].equals(name)){
                    System.out.printf("%s work's in %s and salary is %s", nextLine[1], nextLine[2], nextLine[3]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
