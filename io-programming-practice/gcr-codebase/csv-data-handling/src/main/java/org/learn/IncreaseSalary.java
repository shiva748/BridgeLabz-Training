package org.learn;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class IncreaseSalary {

    public static void main(String[] args) {

        String inputFile = "src/main/resources/csv/employee.csv";
        String tempFile  = "src/main/resources/csv/employee_temp.csv";

        try (
                CSVReader reader = new CSVReader(new FileReader(inputFile));
                CSVWriter writer = new CSVWriter(new FileWriter(tempFile))
        ) {

            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {

                if (isHeader) {
                    writer.writeNext(line);
                    isHeader = false;
                    continue;
                }
                if(line[2].equalsIgnoreCase("IT")){
                    double salary = Double.parseDouble(line[3]);
                    salary = salary + (salary * 0.10);
                    line[3] = String.valueOf((int) salary);
                }

                writer.writeNext(line);
            }

            System.out.println("Salary increased successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        java.io.File oldFile = new java.io.File(inputFile);
        java.io.File newFile = new java.io.File(tempFile);

        if (oldFile.delete()) {
            newFile.renameTo(oldFile);
        }
    }
}
