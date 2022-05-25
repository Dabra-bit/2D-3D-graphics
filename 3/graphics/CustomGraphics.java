package graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import factories.CircleFactory;
import factories.LinesFactory;
import ellipses.BasicEllipse;
import ellipses.CustomEllipse;
import circles.CustomCircle;
import lines.CustomLine;
import points.CustomPoint;
import rectangles.BasicRectangle;
import rectangles.CustomRectangle;

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

    private void paintPixel(CustomPoint p) {
        this.pixel.setRGB(0, 0, this.color.getRGB());

        if (this.drawnImage == null)
            this.paint(this.getGraphics());

        this.drawnImageGraphics.drawImage(this.pixel, p.x(), p.y(), this);
    }

    private void drawFigure(List<CustomPoint> pointsToDraw) {
        for (CustomPoint point : pointsToDraw) {
            this.paintPixel(point);
        }
    }

    public void drawPixel(CustomPoint p) {
        List<CustomPoint> pointsToDraw = new ArrayList<>();
        pointsToDraw.add(p);

        this.drawFigure(pointsToDraw);
    }

    public void drawLine(CustomPoint p1, CustomPoint p2, int lineType, int thick, boolean[] mask) {
        LinesFactory linesFactory = new LinesFactory();
        CustomLine newLine = linesFactory.getCustomLine(p1, p2, lineType, mask);
        List<CustomPoint> pointsToDraw = newLine.computeLinePoints();

        // Apply mask
        pointsToDraw = newLine.filterLine(pointsToDraw);

        // Line thick
        if (thick != 1) {
            pointsToDraw = newLine.makeLineThicker(thick, pointsToDraw);
        }

        this.drawFigure(pointsToDraw);
    }

    public void drawCircle(CustomPoint center, int radius, int circleType, int thick, boolean[] mask) {
        CircleFactory circleFactory = new CircleFactory();
        CustomCircle newCircle = circleFactory.getCircle(center, radius, circleType, mask);
        List<CustomPoint> pointsToDraw = newCircle.computeFigurePoints();

        // Apply mask
        pointsToDraw = newCircle.filterCircle(pointsToDraw);

        if (thick > 1) {
            pointsToDraw = CustomCircle.makeCircleThicker(thick, pointsToDraw);
        }

        this.drawFigure(pointsToDraw);
    }

    public void drawEllipse(CustomPoint center, int yRadius, int xRadius) {
        CustomEllipse newEllipse = new BasicEllipse(center, yRadius, xRadius);
        List<CustomPoint> pointsToDraw = newEllipse.computeFigurePoints();

        this.drawFigure(pointsToDraw);
    }

    public void drawRectangle(CustomPoint point1, CustomPoint point2) {
        CustomRectangle newRectangle = new BasicRectangle(point1, point2);
        List<CustomPoint> pointsToDraw = newRectangle.computeFigurePoints();

        this.drawFigure(pointsToDraw);
    }

    @Override
    public void paint(Graphics g) {
        if (this.drawnImage == null) {
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