package circles;

import java.util.ArrayList;
import java.util.List;

import points.CustomPoint;

public class BasicCircle extends CustomCircle {

    public BasicCircle(CustomPoint center, int radius) {
        super(center, radius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();
        
        final int startingX = this.center.x() - this.radius;
        final int endingX = this.center.x() + this.radius;

        final int sqrRadius = this.radius * this.radius;
        
        for(int x = startingX; x <= endingX; x++) {
            int sqrXdifference = (x - this.center.x()) * (x - this.center.x());
            
            double yPositive = this.center.y() + Math.sqrt(sqrRadius - sqrXdifference);
            double yNegative = this.center.y() - Math.sqrt(sqrRadius - sqrXdifference);

            computedPoints.add(new CustomPoint(x, (int) Math.round(yPositive)));
            computedPoints.add(new CustomPoint(x, (int) Math.round(yNegative)));
        }

        return computedPoints;
    }
    
}
