package main.java.com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JTextArea display;
    private JButton[] buttons;

    public View() {
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    private void initComponents() {
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu arxiusMenu = new JMenu("Arxius");
        arxiusMenu.add(new JMenuItem("Sortir"));
        JMenu operacionsMenu = new JMenu("Operacions");
        operacionsMenu.add(new JMenuItem("Netejar"));
        operacionsMenu.add(new JMenuItem("Igual"));
        menuBar.add(arxiusMenu);
        menuBar.add(operacionsMenu);
        setJMenuBar(menuBar);

        // Display
        display = new JTextArea(2, 10);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        contentPane.add(display, BorderLayout.NORTH);

        // Botones
        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "+", "C",
                "4", "5", "6", "-", "/",
                "1", "2", "3", "x", "=",
                "0", ".", " ", " ", " "
        };

        buttons = new JButton[buttonLabels.length];

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            buttons[i] = button;
            buttonPanel.add(button);
        }

        contentPane.add(buttonPanel, BorderLayout.CENTER);
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    public String getDisplayText() {
        return display.getText();
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public JButton getButton(int index) {
        return buttons[index];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().setVisible(true);
            }
        });
    }
}
