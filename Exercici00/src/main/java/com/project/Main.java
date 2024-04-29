package com.project;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Inici del fil d'execució de SWING
        SwingUtilities.invokeLater(() -> {

            new MainWindow().setVisible(true);
        });
    }
}