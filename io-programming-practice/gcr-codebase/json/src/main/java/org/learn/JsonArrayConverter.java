package org.learn;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayConverter {

    static class User {
        int id;
        String name;
        int age;

        User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Aman", 22));
        users.add(new User(2, "Riya", 28));
        users.add(new User(3, "Kabir", 31));

        JSONArray jsonArray = new JSONArray();

        for (User u : users) {
            JSONObject obj = new JSONObject();
            obj.put("id", u.id);
            obj.put("name", u.name);
            obj.put("age", u.age);
            jsonArray.put(obj);
        }

        System.out.println("\nJSON Array:");
        System.out.println(jsonArray.toString(2));
    }
}

