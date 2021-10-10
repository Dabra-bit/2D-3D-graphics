import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class CustomWindow extends JFrame {
        
    // Custom Graphics
    private CustomGraphics customGraphics;

    public CustomWindow(String title, int width, int height) {
        super(title);

        JPanel panel = new JPanel();
        customGraphics = new CustomGraphics(panel);

        this.configureFrame(width, height, panel);
        this.paint(this.getGraphics());
    }

    private void configureFrame(int width, int height, JPanel panel) {
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // Disable window risizing
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void setColor(Color color) {
        this.customGraphics.setColor(color);
    }

    public void drawPixel(int x, int y) {
        this.customGraphics.drawPixel(new CustomPoint(x, y));
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.customGraphics.drawLine(
            new CustomPoint(x1, y1),
            new CustomPoint(x2, y2)
            );
    }

    public void drawPixel(int x, int y, Color color) {
        this.setColor(color);
        this.drawPixel(x, y);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        this.setColor(color);
        this.drawLine(x1, y1, x2, y2);
    }
}
