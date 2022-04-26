package rectangles;

import java.util.ArrayList;
import java.util.List;

import factories.LinesFactory;
import lines.CustomLine;
import points.CustomPoint;

public class BasicRectangle extends CustomRectangle {

    public BasicRectangle(CustomPoint point1, CustomPoint point2) {
        super(point1, point2);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints;

        CustomPoint p1 = new CustomPoint(this.point1.x(), this.point1.y());
        CustomPoint p2 = new CustomPoint(this.point2.x(), this.point1.y());
        CustomPoint p3 = new CustomPoint(this.point1.x(), this.point2.y());
        CustomPoint p4 = new CustomPoint(this.point2.x(), this.point2.y());

        LinesFactory linesFactory = new LinesFactory();
        CustomLine line1 = linesFactory.getCustomLine(p1, p2, 0, LinesFactory.DEFAULT_MASK);
        CustomLine line2 = linesFactory.getCustomLine(p1, p3, 0, LinesFactory.DEFAULT_MASK);
        CustomLine line3 = linesFactory.getCustomLine(p2, p4, 0, LinesFactory.DEFAULT_MASK);
        CustomLine line4 = linesFactory.getCustomLine(p3, p4, 0, LinesFactory.DEFAULT_MASK);

        computedPoints = line1.computeLinePoints();
        computedPoints.addAll(line2.computeLinePoints());
        computedPoints.addAll(line3.computeLinePoints());
        computedPoints.addAll(line4.computeLinePoints());

        return computedPoints;
    }
    
}
