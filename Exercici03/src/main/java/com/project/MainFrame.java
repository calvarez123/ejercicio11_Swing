package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private ViewForm viewForm;
    private ViewLoading viewLoading;
    private ViewInfo viewInfo;
    private UserController userController;
    private UserModel userModel;

    public MainFrame() {
        userModel = new UserModel();
        userController = new UserController(userModel);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        viewForm = new ViewForm(e -> {
            userController.updateUserInfo(
                viewForm.getName(),
                viewForm.getPhoneNumber(),
                viewForm.getAge(),
                viewForm.getEmail()
            );
            cardLayout.show(cardPanel, "LOADING");
            new Timer(150, new ActionListener() {
                int progress = 0;
                public void actionPerformed(ActionEvent evt) {
                    progress += 10;
                    viewLoading.updateProgress(progress);
                    if (progress >= 100) {
                        ((Timer)evt.getSource()).stop();
                        viewInfo.setText(
                            "Name: " + userModel.getName() + "\n" +
                            "Phone: " + userModel.getPhoneNumber() + "\n" +
                            "Age: " + userModel.getAge() + "\n" +
                            "Email: " + userModel.getEmail()
                        );
                        cardLayout.show(cardPanel, "INFO");
                    }
                }
            }).start();
        });

        viewLoading = new ViewLoading();
        viewInfo = new ViewInfo();

        cardPanel.add(viewForm, "FORM");
        cardPanel.add(viewLoading, "LOADING");
        cardPanel.add(viewInfo, "INFO");

        add(cardPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
