package org.learn;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonAgeFilter {
    public static void main(String[] args) {
        JSONArray users = new JSONArray();

        users.put(new JSONObject().put("name", "Aman").put("age", 22));
        users.put(new JSONObject().put("name", "Riya").put("age", 28));
        users.put(new JSONObject().put("name", "Kabir").put("age", 31));
        users.put(new JSONObject().put("name", "Neha").put("age", 24));

        System.out.println("\nUsers older than 25:");
        for (int i = 0; i < users.length(); i++) {
            JSONObject u = users.getJSONObject(i);
            if (u.getInt("age") > 25) {
                System.out.println(u.toString());
            }
        }
    }
}
