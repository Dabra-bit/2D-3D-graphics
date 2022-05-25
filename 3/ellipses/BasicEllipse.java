package ellipses;

import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class BasicEllipse extends CustomEllipse {
    private static final double ANGLE_STEP = 0.001;
    private static final double _2PI = 2*Math.PI;

    public BasicEllipse(CustomPoint center, int yRadius, int xRadius) {
        super(center, yRadius, xRadius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        for(double t = 0; t <= _2PI; t += ANGLE_STEP) {
            int x = (int) Math.round(this.center.x() + xRadius * Math.cos(t));
            int y = (int) Math.round(this.center.y() + yRadius * Math.sin(t));

            computedPoints.add(new CustomPoint(x, y));
        }

        return computedPoints;
    }
    
}
