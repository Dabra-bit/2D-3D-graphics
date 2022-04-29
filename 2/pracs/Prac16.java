import java.awt.Color;

import points.CustomPoint;

public class Prac16 {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("16th practice - Circle line thick", 600, 600);
        cw.setColor(Color.BLACK);

        CustomPoint point1 = new CustomPoint(200, 200);

        cw.drawCircle(point1.x(), point1.y(), 100, 3);
        cw.repaint();
    }
}
