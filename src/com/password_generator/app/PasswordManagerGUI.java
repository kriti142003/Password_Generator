package com.password_generator.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagerGUI {
    private JFrame frame;

    public PasswordManagerGUI() {
        frame = new JFrame("Password Manager");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JButton generateButton = new JButton("1. Password Generation");
        JButton strengthButton = new JButton("2. Check Password Strength");
        JButton adviceButton = new JButton("3. Suggestions for a Strong Password");
        JButton exitButton = new JButton("4. Exit");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PasswordGeneratorGUI passwordGenerator = new PasswordGeneratorGUI();
                passwordGenerator.generatePassword();
            }
        });

        strengthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PasswordStrengthCheckerGUI strengthChecker = new PasswordStrengthCheckerGUI();
                strengthChecker.checkPasswordStrength();
            }
        });

        adviceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PasswordAdviceGUI passwordAdvice = new PasswordAdviceGUI();
                passwordAdvice.showAdvice();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(generateButton);
        buttonPanel.add(strengthButton);
        buttonPanel.add(adviceButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                @SuppressWarnings("unused")
				PasswordManagerGUI passwordManager = new PasswordManagerGUI();
            }
        });
    }
}






