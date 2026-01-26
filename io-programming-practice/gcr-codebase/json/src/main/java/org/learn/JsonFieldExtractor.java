package org.learn;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class JsonFieldExtractor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter JSON file path: ");
        String filePath = input.nextLine();

        StringBuilder rawJson = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rawJson.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        JSONObject dataObject;

        try {
            dataObject = new JSONObject(rawJson.toString());
        } catch (Exception e) {
            System.out.println("Invalid JSON format.");
            return;
        }

        String studentName = dataObject.has("name") ? dataObject.getString("name") : "N/A";
        String studentEmail = dataObject.has("email") ? dataObject.getString("email") : "N/A";

        JSONObject filteredObject = new JSONObject();
        filteredObject.put("name", studentName);
        filteredObject.put("email", studentEmail);

        System.out.println("\nExtracted JSON:");
        System.out.println(filteredObject.toString(2));
    }
}
