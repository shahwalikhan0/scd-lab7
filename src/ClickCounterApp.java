import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounterApp extends JFrame {
    private JButton button;
    private JLabel label;
    private int clickCount;

    public ClickCounterApp() {
        setTitle("Click Counter App");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        button = new JButton("Count++");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                label.setText("Button Clicked: " + clickCount + " times");
            }
        });

        label = new JLabel("Button Clicked: 0 times");

        setLayout(new FlowLayout());
        add(button);
        add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClickCounterApp app = new ClickCounterApp();
                app.setVisible(true);
            }
        });
    }
}