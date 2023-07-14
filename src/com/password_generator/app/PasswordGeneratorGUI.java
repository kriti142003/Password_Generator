package com.password_generator.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI {
    private JFrame frame;

    public PasswordGeneratorGUI() {
        frame = new JFrame("Password Generator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Create checkboxes and text field
        JCheckBox capitalLettersCheckBox = new JCheckBox("Include capital letters");
        JCheckBox smallLettersCheckBox = new JCheckBox("Include small letters");
        JCheckBox specialCharactersCheckBox = new JCheckBox("Include special characters");
        JCheckBox numbersCheckBox = new JCheckBox("Include numbers");
        JTextField lengthTextField = new JTextField(10);

        // Create the generate button
        JButton generateButton = new JButton("Generate Password");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lengthText = lengthTextField.getText().trim();
                if (lengthText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid password length.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    int length = Integer.parseInt(lengthText);
                    generatePassword(capitalLettersCheckBox.isSelected(), smallLettersCheckBox.isSelected(),
                            specialCharactersCheckBox.isSelected(), numbersCheckBox.isSelected(), length);
                }
            }
        });

        // Create a panel for the checkboxes and text field
        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));
        optionsPanel.add(capitalLettersCheckBox);
        optionsPanel.add(smallLettersCheckBox);
        optionsPanel.add(specialCharactersCheckBox);
        optionsPanel.add(numbersCheckBox);

        // Create the password length panel
        JPanel lengthPanel = new JPanel(new FlowLayout());
        lengthPanel.add(new JLabel("Password Length:"));
        lengthPanel.add(lengthTextField);

        // Create a panel for the options and length panels
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(lengthPanel, BorderLayout.SOUTH);

        // Add the options panel, length panel, and generate button to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(generateButton, BorderLayout.SOUTH);
    }

    private void generatePassword(boolean includeCapitalLetters, boolean includeSmallLetters,
                                  boolean includeSpecialCharacters, boolean includeNumbers, int length) {
        StringBuilder passwordBuilder = new StringBuilder();
        if (includeCapitalLetters) {
            passwordBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeSmallLetters) {
            passwordBuilder.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeSpecialCharacters) {
            passwordBuilder.append("!@#$%^-_");
        }
        if (includeNumbers) {
            passwordBuilder.append("0123456789");
        }

        String password = "";
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * passwordBuilder.length());
            password += passwordBuilder.charAt(randomIndex);
        }

        JOptionPane.showMessageDialog(frame, "Generated Password:\n" + password, "Password Generated", JOptionPane.INFORMATION_MESSAGE);
    }

    public void generatePassword() {
        frame.setVisible(true);
    }
}






