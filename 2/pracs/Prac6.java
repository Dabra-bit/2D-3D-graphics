import java.awt.Color;

import factories.LinesFactory;
import points.CustomPoint;

public class Prac6 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("6th practice - Rectangle", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(50, 50);
        CustomPoint point2 = new CustomPoint(100, 70);

        cw.drawRectangle(point1.x(), point1.y(), point2.x(), point2.y());
        cw.repaint();
    }
}
