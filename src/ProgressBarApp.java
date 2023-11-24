import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarApp extends JFrame {

    private JProgressBar progressBar;

    public ProgressBarApp() {
        setTitle("Progress Bar Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");

        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(startButton);
        panel.add(resetButton);
        add(panel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetButtonActionPerformed();
            }
        });
    }

    private void startButtonActionPerformed() {
        Timer timer = new Timer(100, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress <= 100) {
                    progressBar.setValue(progress);
                    progress++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    private void resetButtonActionPerformed() {
        progressBar.setValue(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgressBarApp().setVisible(true);
            }
        });
    }
}
