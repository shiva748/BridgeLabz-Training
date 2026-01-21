package org.learn;

import org.json.JSONObject;

import java.util.Scanner;

public class StudentJson {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JSONObject json = new JSONObject();
        System.out.print("Enter Student Name: ");
        json.put("name",sc.nextLine());

        System.out.print("Enter Student Age: ");
        json.put("age",Integer.parseInt(sc.nextLine()));

        System.out.print("Enter Subjects separated by space: ");
        json.put("subjects",sc.nextLine().split(" "));

        System.out.println("\nStudent JSON:");
        System.out.println(json.toString(2)); // pretty print
    }
}