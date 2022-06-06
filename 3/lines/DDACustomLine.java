package lines;
import java.util.ArrayList;
import java.util.List;

import points.CustomPoint;

public class DDACustomLine extends CustomLine {

    public DDACustomLine(CustomPoint point1, CustomPoint point2) {
        super(point1, point2);
    }

    @Override
    public List<CustomPoint> computeLinePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        int dy = this.point2.y() - this.point1.y();
        int dx = this.point2.x() - this.point1.x();

        int step = Math.abs(dy) > Math.abs(dx) ?
            Math.abs(dy) :
            Math.abs(dx);

        double xInc = dx / (double) step;
        double yInc = dy / (double) step;

        double x = this.point1.x();
        double y = this.point1.y();

        for(int i = 0; i <= step; i++) {
            computedPoints.add(new CustomPoint(
                (int) Math.round(x),
                (int) Math.round(y)));

            x = x + xInc;
            y = y + yInc;
        }

        return computedPoints;
    }
    
}
