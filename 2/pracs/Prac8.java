import java.awt.Color;

import circles.CustomCircle;
import factories.CircleFactory;
import factories.LinesFactory;
import points.CustomPoint;

public class Prac8 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("8th practice - Polar coords circle", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(100, 70);

        cw.drawCircle(point1.x(), point1.y(), 50, CircleFactory.POLAR_COORDS_CIRCLE, CustomCircle.DEFAULT_THICKNESS,
                CustomCircle.DEFAULT_MASK);
        cw.repaint();
    }
}
