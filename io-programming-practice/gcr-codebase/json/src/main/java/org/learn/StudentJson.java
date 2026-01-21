package org.learn;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Scanner;

public class StudentJson {

    static JSONObject convert(Object object) {
        JSONObject jsonObject = new JSONObject();
        Class<?> cls = object.getClass();
        Field[] fields = cls.getDeclaredFields();

        try {
            for (Field field : fields) {
                Object value = field.get(object);
                jsonObject.put(field.getName(), value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Subjects separated by space: ");
        String[] subjects = sc.nextLine().split(" ");

        Student student = new Student(name, age, subjects);

        JSONObject json = convert(student);
        System.out.println("\nStudent JSON:");
        System.out.println(json.toString(2)); // pretty print
    }
}

class Student {
    String name;
    Integer age;
    String[] subjects;

    Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}
