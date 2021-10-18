package lines;
import java.util.List;

import points.CustomPoint;

public abstract class CustomLine {
    public static final boolean LOW_SLOPE = false;
    public static final boolean HIGH_SLOPE = true;

    protected CustomPoint point1;
    protected CustomPoint point2;

    protected CustomLine(CustomPoint point1, CustomPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public abstract List<CustomPoint> computeLinePoints();
}
