package org.learn;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;

class JsonKeyValuePrinter {
    public static void main(String[] args) {
        String path = "data.json";
        StringBuilder buffer = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("File read error: " + e.getMessage());
            return;
        }

        JSONObject obj = new JSONObject(buffer.toString());

        System.out.println("\nJSON Keys and Values:");
        for (String key : obj.keySet()) {
            System.out.println(key + " : " + obj.get(key));
        }
    }
}
