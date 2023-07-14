package com.password_generator.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordStrengthCheckerGUI {
    private JFrame frame;

    public PasswordStrengthCheckerGUI() {
        frame = new JFrame("Password Strength Checker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Create the password text area
        JTextArea passwordTextArea = new JTextArea(5, 20);
        passwordTextArea.setEditable(true);

        // Create the check button
        JButton checkButton = new JButton("Check Strength");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = passwordTextArea.getText();
                int strength = PasswordStrengthChecker.calculatePasswordStrength(password);
                String strengthText;

                if (strength < 25) {
                    strengthText = "Weak";
                } else if (strength < 50) {
                    strengthText = "Moderate";
                } else if (strength < 75) {
                    strengthText = "Strong";
                } else {
                    strengthText = "Very Strong";
                }

                JOptionPane.showMessageDialog(frame, "Password Strength: " + strengthText, "Password Strength", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Create a panel for the text area and check button
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(passwordTextArea, BorderLayout.CENTER);
        panel.add(checkButton, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
    }

    public void checkPasswordStrength() {
        frame.setVisible(true);
    }
}






