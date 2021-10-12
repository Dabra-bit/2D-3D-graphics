package lines;
import java.util.List;

import points.CustomPoint;

public interface CustomLineInterface {
    public static final boolean LOW_SLOPE = false;
    public static final boolean HIGH_SLOPE = true;

    public abstract List<CustomPoint> computeLinePoints();
}
