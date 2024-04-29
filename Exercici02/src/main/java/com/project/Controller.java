package main.java.com.project;

public class Controller {
    private CalculatorModel model;
    private View view;

    public Controller() {
        model = new CalculatorModel();
        view = new View(this);
    }

    public void buttonPressed(String command) {
        try {
            double value = Double.parseDouble(command);
            model.add(value); // Por simplificar, asumimos que siempre se añade.
            view.updateTextField(String.valueOf(model.getResult()));
        } catch (NumberFormatException ex) {
            switch (command) {
                case "C":
                    model.reset();
                    view.updateTextField("");
                    break;
                case "+":
                case "-":
                case "x":
                case "/":
                    // Actualiza la operación en el modelo aquí si es necesario
                    break;
                case "=":
                    view.updateTextField(String.valueOf(model.getResult()));
                    break;
            }
        }
    }
}

