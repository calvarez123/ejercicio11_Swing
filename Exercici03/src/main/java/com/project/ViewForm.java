package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewForm extends JPanel {
    private JTextField nameField, phoneNumberField, emailField;
    private JSpinner ageField;
    private JButton sendButton;

    public ViewForm(ActionListener sendListener) {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField(20);
        add(phoneNumberField);

        add(new JLabel("Age:"));
        ageField = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));
        add(ageField);

        add(new JLabel("Email:"));
        emailField = new JTextField(20);
        add(emailField);

        sendButton = new JButton("Send");
        sendButton.addActionListener(sendListener);
        add(sendButton);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public int getAge() {
        return (Integer) ageField.getValue();
    }

    public String getEmail() {
        return emailField.getText();
    }
}
