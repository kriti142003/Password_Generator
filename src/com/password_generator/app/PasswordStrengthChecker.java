package com.password_generator.app;

public class PasswordStrengthChecker {
    public static int calculatePasswordStrength(String password) {
        int score = 0;

        // Check password length
        if (password.length() >= 8) {
            score += 10;
        } else {
            score -= 5;
        }

        // Check if the password contains uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score += 5;
        }

        // Check if the password contains lowercase letters
        if (password.matches(".*[a-z].*")) {
            score += 5;
        }

        // Check if the password contains digits
        if (password.matches(".*\\d.*")) {
            score += 5;
        }

        // Check if the password contains special characters
        if (password.matches(".*[^A-Za-z0-9].*")) {
            score += 5;
        }

        return score;
    }
}


