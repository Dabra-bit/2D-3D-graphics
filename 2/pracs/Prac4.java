import java.awt.Color;

import factories.LinesFactory;
import points.CustomPoint;

public class Prac4 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("4th practice - Bresenham line", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(50, 50);
        CustomPoint point2 = new CustomPoint(100, 70);

        cw.drawLine(point1.x(), point1.y(), point2.x(), point2.y(), LinesFactory.BRESENHAM_LINE);
        cw.repaint();
    }
}
