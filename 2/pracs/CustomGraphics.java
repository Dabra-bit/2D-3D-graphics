import java.awt.Color;
import java.util.List;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import lines.CustomLine;
import lines.DDACustomLine;
import points.CustomPoint;

public class CustomGraphics extends JPanel {
    public static final Color DEFAULT_PIXEL_COLOR = Color.BLACK;

    private Color color;
    private BufferedImage pixel;
    private ImageIcon icon;
    private Image drawnImage;
    private Graphics drawnImageGraphics;

    public CustomGraphics() {
        super();
        this.color = DEFAULT_PIXEL_COLOR;
        this.drawnImage = null;
        this.drawnImageGraphics = null;
        this.initPixel();
        this.add(new JLabel(this.icon));
    }

    public CustomGraphics(Color color) {
        super();
        this.color = color;
        this.drawnImage = null;
        this.drawnImageGraphics = null;
        this.initPixel();
        this.add(new JLabel(this.icon));
    }

    private void initPixel() {
        this.pixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        icon = new ImageIcon(pixel);
    }

    public Image getDrawnImage() {
        return this.drawnImage;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void drawPixel(CustomPoint p) {
        this.pixel.setRGB(0, 0, this.color.getRGB());

        if(this.drawnImage == null)
            this.paint(this.getGraphics());

        this.drawnImageGraphics.drawImage(this.pixel, p.x(), p.y(), this);
    }

    public void drawLine(CustomPoint p1, CustomPoint p2) {
        CustomLine newLine = new DDACustomLine(p1, p2);
        List<CustomPoint> pointsToDraw = newLine.computeLinePoints();

        for (CustomPoint point : pointsToDraw) {
            this.drawPixel(point);
        }
    }

    @Override
    public void paint(Graphics g) {
        if(this.drawnImage == null) {
            this.drawnImage = createImage(getWidth(), getHeight());
        }
        this.drawnImageGraphics = this.drawnImage.getGraphics();
        g.drawImage(this.drawnImage, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        this.paint(g);
    }
}