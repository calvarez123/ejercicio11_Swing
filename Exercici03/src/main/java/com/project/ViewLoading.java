package com.project;

import javax.swing.*;
import java.awt.*;

public class ViewLoading extends JPanel {
    private JProgressBar progressBar;

    public ViewLoading() {
        setLayout(new BorderLayout());
        progressBar = new JProgressBar(0, 100);
        add(progressBar, BorderLayout.CENTER);
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }
}

