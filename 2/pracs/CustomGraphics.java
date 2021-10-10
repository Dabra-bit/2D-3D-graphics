import java.awt.Color;
import java.util.List;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;

public class CustomGraphics {
    public static final Color DEFAULT_PIXEL_COLOR = Color.BLACK;

    private JComponent component;
    private Color color;
    private BufferedImage pixel;

    public CustomGraphics(JComponent component) {
        this.component = component;
        this.color = DEFAULT_PIXEL_COLOR;
        this.pixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_BGR);
    }

    public CustomGraphics(JComponent component, Color color) {
        this.component = component;
        this.color = color;
        this.pixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_BGR);
    }

    public JComponent getComponent() {
        return this.component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawPixel(CustomPoint p) {
        this.pixel.setRGB(0, 0, this.color.getRGB());
        this.component.getGraphics().drawImage(this.pixel, p.x(), p.y(), this.component);
    }

    public void drawLine(CustomPoint p1, CustomPoint p2) {
        CustomLine newLine = new CustomLine(p1, p2);
        List<CustomPoint> pointsToDraw = newLine.computeLinePoints();

        for (CustomPoint point : pointsToDraw) {
            this.drawPixel(point);
        }
    }
}