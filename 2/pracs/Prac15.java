import java.awt.Color;

import points.CustomPoint;

public class Prac15 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("15th practice - Types of lines circle", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(200, 200);

        boolean[] mask = { true, true, true, true, true, false, false, false, false, false };
        cw.drawCircle(point1.x(), point1.y(), 100, mask);
        cw.repaint();
    }
}
