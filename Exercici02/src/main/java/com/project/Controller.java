package main.java.com.project;

import java.awt.event.ActionEvent;

public class Controller {

    private View view;
    private double firstValue;
    private double secondValue;
    private char operation;

    public Controller(View view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.setDefaultCloseOperation(View.EXIT_ON_CLOSE);
        view.setVisible(true);
        view.setResizable(false);
        view.setSize(300, 400);

        view.getMenuBar().getMenu(1).getItem(0).addActionListener(e -> clearDisplay());
        view.getMenuBar().getMenu(1).getItem(1).addActionListener(e -> calculateResult());

        // Configurar ActionListener para cada botón de la calculadora
        for (int i = 0; i < view.getButtonCount(); i++) {
            view.getButton(i).addActionListener(this::controllerButtonAction);
        }
    }

    private void clearDisplay() {
        view.setDisplayText("");
    }

    private void calculateResult() {
        String expression = view.getDisplayText();
        if (!expression.isEmpty()) {
            String[] parts = expression.split(" ");
            if (parts.length == 3) {
                try {
                    firstValue = Double.parseDouble(parts[0]);
                    operation = parts[1].charAt(0);
                    secondValue = Double.parseDouble(parts[2]);

                    double result = performOperation(firstValue, secondValue, operation);
                    view.setDisplayText(Double.toString(result));
                } catch (NumberFormatException e) {
                    view.setDisplayText("Error");
                }
            } else {
                view.setDisplayText("Error");
            }
        }
    }

    private double performOperation(double firstValue, double secondValue, char operation) {
        switch (operation) {
            case '+':
                return firstValue + secondValue;
            case '-':
                return firstValue - secondValue;
            case 'x':
                return firstValue * secondValue;
            case '/':
                if (secondValue != 0) {
                    return firstValue / secondValue;
                } else {
                    return Double.POSITIVE_INFINITY; // División por cero
                }
            default:
                return 0; // Operación no reconocida
        }
    }

    public void controllerButtonAction(ActionEvent e) {
        String command = e.getActionCommand();
        view.setDisplayText(view.getDisplayText() + command);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
    }
}
