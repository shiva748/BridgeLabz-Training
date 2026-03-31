package org.learn;

import org.json.JSONObject;

public class JsonMerger {

    public static void main(String[] args) {

        JSONObject jsonA = new JSONObject();
        jsonA.put("id", 101);
        jsonA.put("name", "Aarav");
        jsonA.put("city", "Delhi");

        JSONObject jsonB = new JSONObject();
        jsonB.put("email", "aarav@example.com");
        jsonB.put("phone", "+91-9999999999");
        jsonB.put("city", "Mumbai");

        JSONObject mergedJson = new JSONObject();

        for (String key : jsonA.keySet()) {
            mergedJson.put(key, jsonA.get(key));
        }

        for (String key : jsonB.keySet()) {
            mergedJson.put(key, jsonB.get(key));
        }

        System.out.println("JSON Object A:");
        System.out.println(jsonA.toString(2));

        System.out.println("\nJSON Object B:");
        System.out.println(jsonB.toString(2));

        System.out.println("\nMerged JSON Object:");
        System.out.println(mergedJson.toString(2));
    }
}
