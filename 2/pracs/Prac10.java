import java.awt.Color;

import factories.CircleFactory;
import points.CustomPoint;

public class Prac10 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("10th practice - Middle point circle", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(100, 70);

        cw.drawCircle(point1.x(), point1.y(), 50, CircleFactory.MIDDLE_POINT_CIRCLE);
        cw.repaint();
    }
}
