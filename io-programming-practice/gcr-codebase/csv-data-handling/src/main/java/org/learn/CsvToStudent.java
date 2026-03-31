package org.learn;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToStudent {

    public static void main(String[] args) {

        String filePath = "src/main/resources/csv/students.csv";
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null) {

                int id = Integer.parseInt(row[0]);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                int marks = Integer.parseInt(row[3]);

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return;
        }

        System.out.println("Student List:");
        System.out.println("-------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

class Student {

    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}