package rectangles;

import java.util.List;

import points.CustomPoint;

public abstract class CustomRectangle {
    protected CustomPoint point1;
    protected CustomPoint point2;

    
    protected CustomRectangle(CustomPoint point1, CustomPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public abstract List<CustomPoint> computeFigurePoints();
}
