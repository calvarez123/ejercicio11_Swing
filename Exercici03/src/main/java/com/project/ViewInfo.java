package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewInfo extends JPanel {
    private JTextArea infoArea;

    public ViewInfo() {
        setLayout(new BorderLayout());
        infoArea = new JTextArea(10, 40);
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }

    public void setText(String text) {
        infoArea.setText(text);
    }
}
