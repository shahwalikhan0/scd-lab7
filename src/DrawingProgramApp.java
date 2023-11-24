import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class DrawingProgramApp extends JFrame {
    private JPanel canvas;
    private ShapeType currentShape;

    public DrawingProgramApp() {
        setTitle("Drawing Program");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        canvas = new JPanel() {
            private Shape shape;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (shape != null) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(Color.BLACK);
                    g2d.draw(shape);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            private int startX, startY;

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int endX = e.getX();
                int endY = e.getY();
                int width = Math.abs(endX - startX);
                int height = Math.abs(endY - startY);

                switch (currentShape) {
                    case LINE:
                        canvas.getGraphics().drawLine(startX, startY, endX, endY);
                        break;
                    case RECTANGLE:
                        canvas.getGraphics().drawRect(startX, startY, width, height);
                        break;
                    case ELLIPSE:
                        canvas.getGraphics().drawOval(startX, startY, width, height);
                        break;
                }
                canvas.repaint();
            }
        });

        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> currentShape = ShapeType.LINE);

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(e -> currentShape = ShapeType.RECTANGLE);

        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.addActionListener(e -> currentShape = ShapeType.ELLIPSE);

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    private enum ShapeType {
        LINE, RECTANGLE, ELLIPSE
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingProgramApp app = new DrawingProgramApp();
            app.setVisible(true);
        });
    }
}