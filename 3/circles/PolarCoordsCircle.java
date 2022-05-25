package circles;

import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class PolarCoordsCircle extends CustomCircle {

    private static final double ANGLE_STEP = 0.001;
    private static final double _2PI = 2*Math.PI;

    public PolarCoordsCircle(CustomPoint center, int radius) {
        super(center, radius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        for(double t = 0; t <= _2PI; t += ANGLE_STEP) {
            int x = (int) Math.round(this.center.x() + this.radius * Math.sin(t));
            int y = (int) Math.round(this.center.y() + this.radius * Math.cos(t));

            computedPoints.add(new CustomPoint(x, y));
        }

        return computedPoints;
    }
    
}
