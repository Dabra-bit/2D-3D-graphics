import java.awt.Color;

import factories.CircleFactory;
import factories.LinesFactory;
import points.CustomPoint;

public class Prac7 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("7th practice - Cartesian coords circle", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(100, 70);

        cw.drawCircle(point1.x(), point1.y(), 50, CircleFactory.BASIC_CIRCLE);
        cw.repaint();
    }
}
