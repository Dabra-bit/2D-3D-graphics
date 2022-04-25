package lines;
import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class MiddlePointLine extends CustomLine {
    
    public MiddlePointLine(CustomPoint point1, CustomPoint point2) {
        super(point1, point2);
    }

    private boolean isHighSlope() {
        final int dy = this.point2.y() - this.point1.y();
        final int dx = this.point2.x() - this.point1.x();

        return dx == 0 || Math.abs(dy) > Math.abs(dx);
    }

    private void swapPoints() {
        CustomPoint temporalPoint = this.point1;
        this.point1 = this.point2;
        this.point2 = temporalPoint; 
    }

    private void sortPoints() {
        boolean typeOfSlope = this.isHighSlope();

        if(typeOfSlope == LOW_SLOPE && this.point1.x() > this.point2.x()) {
            this.swapPoints();
        }

        if(typeOfSlope == HIGH_SLOPE && this.point1.y() > this.point2.y()) {
            this.swapPoints();
        }
    }

    @Override
    public List<CustomPoint> computeLinePoints() {        
        this.sortPoints();

        List<CustomPoint> computedPoints = new ArrayList<>();
        int x = point1.x();
        int y = point1.y();

        int aComp = this.point2.y() - this.point1.y();
        int bComp = this.point1.x() - this.point2.x();
        int dk = 2 * aComp + bComp;

        while(x <= point2.x()) {
            computedPoints.add(new CustomPoint(x, y));
            
            if(dk <= 0) {
                x++;
                dk += 2*aComp;
            } else {
                x++;
                y++;
                dk += 2 * (aComp + bComp);
            }
        }

        return computedPoints;
    }
    
}
