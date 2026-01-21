package org.learn;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortBySalary {

    public static void main(String[] args) {

        String filePath = "src/main/resources/csv/employee.csv";

        List<String[]> employees = new ArrayList<>();
        String[] header;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            header = reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                employees.add(line);
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return;
        }

        employees.sort(
                Comparator.<String[]>comparingInt(emp -> Integer.parseInt(emp[3]))
                        .reversed()
        );

        System.out.println("Top 5 Highest Paid Employees");
        System.out.println("-------------------------------------");
        System.out.println(String.join(" | ", header));

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(String.join(" | ", employees.get(i)));
        }
    }
}
