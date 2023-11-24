import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPaletteApp extends JFrame {
    private JPanel colorPanel;
    private JComboBox<String> colorComboBox;

    public ColorPaletteApp() {
        setTitle("Color Palette");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);

        colorComboBox = new JComboBox<>(new String[]{"Red", "Green", "Blue"});
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        colorPanel.setBackground(Color.RED);
                        break;
                    case "Green":
                        colorPanel.setBackground(Color.GREEN);
                        break;
                    case "Blue":
                        colorPanel.setBackground(Color.BLUE);
                        break;
                }
            }
        });

        setLayout(new BorderLayout());
        add(colorPanel, BorderLayout.CENTER);
        add(colorComboBox, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorPaletteApp app = new ColorPaletteApp();
                app.setVisible(true);
            }
        });
    }
}
