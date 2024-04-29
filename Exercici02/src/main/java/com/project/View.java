package main.java.com.project;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JTextField textField;
    private JButton[] buttons;
    private CalculatorModel controller;

    public View(Controller controller2) {
        super("Calculadora");
        this.controller = controller2;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] labels = {
            "C", "", "", "+",
            "7", "8", "9", "-",
            "4", "5", "6", "x",
            "1", "2", "3", "/",
            "0", "", "", "="
        };

        buttons = new JButton[labels.length];
        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].addActionListener(e -> controller2.buttonPressed(e.getActionCommand()));
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void updateTextField(String text) {
        textField.setText(text);
    }
}
