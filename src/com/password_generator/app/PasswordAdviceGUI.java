package com.password_generator.app;

import javax.swing.*;
import java.awt.*;

public class PasswordAdviceGUI {
    private JFrame frame;
    public PasswordAdviceGUI() {
        frame = new JFrame("Password Advice");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JTextArea adviceTextArea = new JTextArea();
        adviceTextArea.setEditable(false);
        adviceTextArea.append("Here are some tips for creating a strong password:\n\n");
        adviceTextArea.append("- Use a combination of uppercase and lowercase letters\n");
        adviceTextArea.append("- Include numbers and special characters\n");
        adviceTextArea.append("- Make your password at least 8 characters long\n");
        adviceTextArea.append("- Avoid using common phrases or personal information\n");
        adviceTextArea.append("- Regularly update your passwords\n");
        JScrollPane scrollPane = new JScrollPane(adviceTextArea);
        frame.add(scrollPane, BorderLayout.CENTER);
    }
    public void showAdvice() {
        frame.setVisible(true);
    }
}

