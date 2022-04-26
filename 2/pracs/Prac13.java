import java.awt.Color;

import factories.LinesFactory;
import points.CustomPoint;

public class Prac13 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("14th practice - Line thick", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(50, 50);
        CustomPoint point2 = new CustomPoint(200, 70);

        boolean[] mask = {true, true, true, true, false, false, true, true, false, false};

        cw.drawLine(point1.x(), point1.y(), point2.x(), point2.y(), LinesFactory.BRESENHAM_LINE, 7, mask);
        cw.repaint();
    }
}
