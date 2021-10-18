import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;

import points.CustomPoint;

public class CustomWindow extends JFrame {
        
    // Custom Graphics
    private CustomGraphics customGraphics;

    public CustomWindow(String title, int width, int height) {
        super(title);
        this.paint(this.getGraphics());

        customGraphics = new CustomGraphics();
        this.configureFrame(new Dimension(width, height),
            customGraphics);
    }

    private void configureFrame(Dimension dimension, JPanel panel) {
        this.add(panel);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void setColor(Color color) {
        this.customGraphics.setColor(color);
    }

    public void drawPixel(int x, int y) {
        this.customGraphics.drawPixel(new CustomPoint(x, y));
    }

    public void drawLine(int x1, int y1, int x2, int y2, int lineType) {
        this.customGraphics.drawLine(
            new CustomPoint(x1, y1),
            new CustomPoint(x2, y2),
            lineType
            );
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.drawLine(x1, y1, x2, y2, 0);
    }
}
