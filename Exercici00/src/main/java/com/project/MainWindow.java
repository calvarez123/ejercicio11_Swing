package com.project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JLabel sliderValueLabel;
    private JSlider slider;
    private JRadioButton opcion1RadioButton, opcion2RadioButton, opcion3RadioButton;
    private JLabel opcionSeleccionadaLabel, volumenLabel, textoEscritoLabel;
    private JTextField textField;

    public MainWindow() {
        super("Mi Aplicación");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        updateLabelFromSlider();
    }

    private void initComponents () {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(panel);

        JLabel tituloOpciones = new JLabel("Selector de Opción");
        tituloOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloOpciones);

        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(opcionesPanel);

        ButtonGroup opcionesGroup = new ButtonGroup();
        opcion1RadioButton = new JRadioButton("Opción 1");
        opcion2RadioButton = new JRadioButton("Opción 2");
        opcion3RadioButton = new JRadioButton("Opción 3");
        opcionesGroup.add(opcion1RadioButton);
        opcionesGroup.add(opcion2RadioButton);
        opcionesGroup.add(opcion3RadioButton);
        opcionesPanel.add(opcion1RadioButton);
        opcionesPanel.add(opcion2RadioButton);
        opcionesPanel.add(opcion3RadioButton);

        opcion1RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResultLabels();
            }
        });
        opcion2RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResultLabels();
            }
        });
        opcion3RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateResultLabels();
            }
        });

        panel.add(Box.createVerticalStrut(10));

        JLabel tituloVolumen = new JLabel("Selector de Volumen");
        tituloVolumen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloVolumen);

        JPanel volumenPanel = new JPanel();
        volumenPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(volumenPanel);

        slider = new JSlider(0, 100, 50);
        slider.setPreferredSize(new Dimension(300, 50));
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateLabelFromSlider();
            }
        });
        volumenPanel.add(slider);

        sliderValueLabel = new JLabel("");

        panel.add(Box.createVerticalStrut(10));

        JLabel tituloTexto = new JLabel("Texto");
        tituloTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloTexto);

        JPanel textoPanel = new JPanel();
        textoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(textoPanel);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateResultLabels();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateResultLabels();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateResultLabels();
            }
        });
        textoPanel.add(textField);

        panel.add(Box.createVerticalStrut(10));

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetValues();
            }
        });
        panel.add(resetButton);

        panel.add(Box.createVerticalStrut(10));

        JPanel resultadosPanel = new JPanel();
        resultadosPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(resultadosPanel);

        opcionSeleccionadaLabel = new JLabel("Opción seleccionada: ");
        resultadosPanel.add(opcionSeleccionadaLabel);

        volumenLabel = new JLabel("Volumen: ");
        resultadosPanel.add(volumenLabel);

        textoEscritoLabel = new JLabel("Texto escrito: ");
        resultadosPanel.add(textoEscritoLabel);
    }

    private void updateLabelFromSlider () {
        sliderValueLabel.setText("Volumen: " + slider.getValue());
        updateResultLabels();
    }

    private void resetValues() {
        opcion1RadioButton.setSelected(true);
        slider.setValue(50);
        textField.setText("");
        updateResultLabels();
    }

    private void updateResultLabels() {
        String opcionSeleccionada = "";
        if (opcion1RadioButton.isSelected()) {
            opcionSeleccionada = opcion1RadioButton.getText();
        } else if (opcion2RadioButton.isSelected()) {
            opcionSeleccionada = opcion2RadioButton.getText();
        } else if (opcion3RadioButton.isSelected()) {
            opcionSeleccionada = opcion3RadioButton.getText();
        }
        opcionSeleccionadaLabel.setText("Opción seleccionada: " + opcionSeleccionada);
        volumenLabel.setText("Volumen: " + slider.getValue());
        textoEscritoLabel.setText("Texto escrito: " + textField.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
