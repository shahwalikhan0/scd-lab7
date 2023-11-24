import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageViewerApp extends JFrame {
    private JLabel imageLabel;
    private JButton previousButton;
    private JButton nextButton;
    private File[] imageFiles;
    private int currentIndex;

    public ImageViewerApp() {
        setTitle("Image Viewer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void loadImages(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            imageFiles = directory.listFiles();
            currentIndex = 0;
            showImage();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid directory path", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showImage() {
        try {
            File imageFile = imageFiles[currentIndex];
            Image image = ImageIO.read(imageFile);
            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showPreviousImage() {
        if (currentIndex > 0) {
            currentIndex--;
            showImage();
        }
    }

    private void showNextImage() {
        if (currentIndex < imageFiles.length - 1) {
            currentIndex++;
            showImage();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageViewerApp app = new ImageViewerApp();
                app.loadImages("path/to/images/directory");
                app.setVisible(true);
            }
        });
    }
}
