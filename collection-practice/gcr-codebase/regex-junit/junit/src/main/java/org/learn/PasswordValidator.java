package org.learn;

public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*");
    }
}
