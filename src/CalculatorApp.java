import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField displayField;
    private JButton[] digitButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private String currentNumber = "";
    private String lastOperation;
    private double result;

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayField = new JTextField();
        displayField.setEditable(false);

        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            final int digit = i;
            digitButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentNumber += digit;
                    displayField.setText(currentNumber);
                }
            });
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        ActionListener operationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = e.getActionCommand();
                calculate(operation);
            }
        };
        for (JButton button : operationButtons) {
            button.addActionListener(operationListener);
        }

        equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate("");
            }
        });

        clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        setLayout(new GridLayout(5, 3));
        add(displayField);
        for (JButton button : digitButtons) {
            add(button);
        }
        for (JButton button : operationButtons) {
            add(button);
        }
        add(equalsButton);
        add(clearButton);
    }

    void calculate(String operation) {
        if (currentNumber != null && !currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            if (lastOperation != null) {
                switch (lastOperation) {
                    case "+":
                        result += number;
                        break;
                    case "-":
                        result -= number;
                        break;
                    case "*":
                        result *= number;
                        break;
                    case "/":
                        result /= number;
                        break;
                }
            } else {
                result = number;
            }
            currentNumber = "";
            lastOperation = operation;
            displayField.setText(String.valueOf(result));
        }
    }

    void clear() {
        currentNumber = "";
        lastOperation = null;
        result = 0;
        displayField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorApp app = new CalculatorApp();
                app.setVisible(true);
            }
        });
    }

    public void setCurrentNumber(String number) {
        currentNumber = number;
    }

    public String getDisplayFieldText() {
        return displayField.getText();
    }
}
