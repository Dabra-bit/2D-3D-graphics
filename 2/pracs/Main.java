import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import factories.CircleFactory;
import factories.LinesFactory;
import points.CustomPoint;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("6th practice - Curve 3.7", 600, 600);
        cw.setColor(Color.BLUE);

        final int sizeFactor = 10;
        final double limit = 14 * Math.PI;

        List<CustomPoint> points = new ArrayList<>();

        for(double t = 0; t <= limit; t += 0.01) {
            double x = 17 * Math.cos(t) + 7 * Math.cos(17 / (double) 7 * t);
            double y = 17 * Math.sin(t) - 7 * Math.sin(17 / (double) 7 * t);

            int xScalated = (int) Math.ceil(sizeFactor * x + 250);
            int yScalated = (int) Math.ceil(sizeFactor * y + 250);

            points.add(new CustomPoint(xScalated, yScalated));
        }

        for(int i = 0; i < points.size() - 1; i++) {
            CustomPoint point1 = points.get(i);
            CustomPoint point2 = points.get(i + 1);
            cw.drawLine(point1.x(), point1.y(), point2.x(), point2.y());
        }

        // cw.setColor(Color.RED);

        // for(CustomPoint point : points) {
        //     cw.drawPixel(point.x(), point.y());
        // }

        cw.repaint();
    }
}
