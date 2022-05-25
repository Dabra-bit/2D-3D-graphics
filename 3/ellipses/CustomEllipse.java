package ellipses;

import java.util.List;

import points.CustomPoint;

public abstract class CustomEllipse {
    protected CustomPoint center;
    protected int yRadius;
    protected int xRadius;
    
    protected CustomEllipse(CustomPoint center, int yRadius, int xRadius) {
        this.center = center;
        this.yRadius = yRadius;
        this.xRadius = xRadius;
    }

    public abstract List<CustomPoint> computeFigurePoints();
}
