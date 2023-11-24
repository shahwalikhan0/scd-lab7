import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends JFrame {
    private JTextField inputField;
    private JComboBox<String> sourceUnitComboBox;
    private JComboBox<String> targetUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverterApp() {
        setTitle("Temperature Converter");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputField = new JTextField();

        sourceUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});

        targetUnitComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius"});

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        resultLabel = new JLabel();

        setLayout(new GridLayout(4, 2));
        add(new JLabel("Temperature:"));
        add(inputField);
        add(new JLabel("Source Unit:"));
        add(sourceUnitComboBox);
        add(new JLabel("Target Unit:"));
        add(targetUnitComboBox);
        add(convertButton);
        add(resultLabel);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String sourceUnit = (String) sourceUnitComboBox.getSelectedItem();
            String targetUnit = (String) targetUnitComboBox.getSelectedItem();
            double convertedTemperature;

            if (sourceUnit.equals("Celsius") && targetUnit.equals("Fahrenheit")) {
                convertedTemperature = (temperature * 9 / 5) + 32;
            } else if (sourceUnit.equals("Fahrenheit") && targetUnit.equals("Celsius")) {
                convertedTemperature = (temperature - 32) * 5 / 9;
            } else {
                resultLabel.setText("Invalid conversion");
                return;
            }

            resultLabel.setText("Converted temperature: " + convertedTemperature + " " + targetUnit);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureConverterApp app = new TemperatureConverterApp();
                app.setVisible(true);
            }
        });
    }
}
