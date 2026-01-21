package org.learn;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeWriter {
    static String[] getDetail(int id, Scanner sc){
        String detail[]= new String[4];
        detail[0] = Integer.toString(id+1);
        System.out.print("Please enter the name of the employee you want to add: ");
        detail[1] = sc.nextLine();
        System.out.print("Please enter the department of the employee you want to add: ");
        detail[2] = sc.nextLine();
        System.out.print("Please enter the salary of the employee you want to add: ");
        detail[3] = sc.nextLine();
        return detail;
    }

    public static void main(String[] args) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/csv/employee.csv"))) {
            writer.writeNext(new String[]{"ID", "Name", "Department", "Salary"});
            Scanner sc = new Scanner(System.in);
            int n = 4;
            for(int i=0; i<n; i++){
                writer.writeNext(getDetail(i, sc));
            }
            System.out.println("CSV file written successfully using OpenCSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
