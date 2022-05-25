package circles;

import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class EightSidedCircle extends CustomCircle {

    private static final double ANGLE_STEP = 0.001;
    private static final double LIMIT = Math.PI / 4;

    public EightSidedCircle(CustomPoint center, int radius) {
        super(center, radius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        int cX = center.x();
        int cY = center.y();
        
        for(double t = 0; t <= LIMIT; t += ANGLE_STEP) {
            int x = (int) Math.round(this.radius * Math.sin(t));
            int y = (int) Math.round(this.radius * Math.cos(t));

            computedPoints.add(new CustomPoint(cX + x, cY +  y));
            computedPoints.add(new CustomPoint(cX + x, cY - y));
            computedPoints.add(new CustomPoint(cX - x, cY +  y));
            computedPoints.add(new CustomPoint(cX - x, cY - y));
            computedPoints.add(new CustomPoint(cX + y, cY + x));
            computedPoints.add(new CustomPoint(cX - y, cY + x));
            computedPoints.add(new CustomPoint(cX + y, cY - x));
            computedPoints.add(new CustomPoint(cX - y, cY - x));
        }

        return computedPoints;
    }
    
}
