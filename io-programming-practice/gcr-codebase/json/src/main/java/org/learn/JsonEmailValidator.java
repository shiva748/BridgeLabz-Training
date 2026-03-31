package org.learn;

import org.json.JSONObject;

public class JsonEmailValidator {
    public static void main(String[] args) {
        JSONObject user = new JSONObject();
        user.put("name", "Rohit");
        user.put("email", "rohit@gmail.com");

        String email = user.getString("email");

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        System.out.println("\nEmail Validation Result:");
        if (email.matches(emailRegex)) {
            System.out.println("Valid email: " + email);
        } else {
            System.out.println("Invalid email: " + email);
        }
    }
}
