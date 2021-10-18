package circles;

import java.util.List;

import points.CustomPoint;

public abstract class CustomCircle {

    protected CustomPoint center;
    protected int radius;

    protected CustomCircle(CustomPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public abstract List<CustomPoint> computeFigurePoints();
}
