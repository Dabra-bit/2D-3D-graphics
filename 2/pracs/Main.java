import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import factories.CircleFactory;
import factories.LinesFactory;
import points.CustomPoint;

public class Main {
    public static void main(String[] args) {
        CustomWindow cw = new CustomWindow("1st prac - Curve 3.2", 600, 600);
        cw.setColor(Color.BLUE);

        final int sizeFactor = 100;
        final int numberOfPointsInCurve = 8;
        double chunk = Math.PI / (numberOfPointsInCurve - 1);

        List<CustomPoint> points = new ArrayList<>();
        double x = 0;

        for(int i = 0; i < numberOfPointsInCurve; i++, x += chunk) {
            int xScalated = (int) Math.ceil(sizeFactor * x);
            int yScalated = (int) Math.ceil(sizeFactor * Math.sin(x));

            points.add(new CustomPoint(xScalated, yScalated));
        }

        for(int i = 0; i < points.size() - 1; i++) {
            CustomPoint point1 = points.get(i);
            CustomPoint point2 = points.get(i + 1);
            cw.drawLine(point1.x(), point1.y(), point2.x(), point2.y());
        }

        cw.setColor(Color.RED);

        for(CustomPoint point : points) {
            cw.drawPixel(point.x(), point.y());
        }

        cw.repaint();
    }
}
