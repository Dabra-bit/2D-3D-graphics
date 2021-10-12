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

        int x = this.point1.x();
        int y = this.point1.y();

        for(int i = 0; i <= step; i++) {
            computedPoints.add(new CustomPoint(x, y));

            x = (int) Math.round(x + xInc);
            y = (int) Math.round(y + yInc);
        }

        return computedPoints;
    }
    
}
