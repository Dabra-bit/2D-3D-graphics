package lines;
import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class BresenhamCustomLine extends CustomLine {
    
    public BresenhamCustomLine(CustomPoint point1, CustomPoint point2) {
        super(point1, point2);
    }

    private boolean isHighSlope2() {
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
        boolean typeOfSlope = this.isHighSlope2();

        if(typeOfSlope == LOW_SLOPE && this.point1.x() > this.point2.x()) {
            this.swapPoints();
        }

        if(typeOfSlope == HIGH_SLOPE && this.point1.y() > this.point2.y()) {
            this.swapPoints();
        }
    }

    private List<CustomPoint> computeLowSlopeLine() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        int dy = this.point2.y() - this.point1.y();
        final int dx = this.point2.x() - this.point1.x();
        int yInc = 1;

        if(dy < 0) {
            yInc = -1;
            dy = -dy;
        }

        final int _2Dy = 2 * dy;
        final int _2Dx = 2 * dx;

        int nextPk = _2Dy - dx;
        int y = this.point1.y();

        for(int x = this.point1.x(); x <= this.point2.x(); x++) {
            computedPoints.add(new CustomPoint(x, y));

            if(nextPk > 0) {
                y += yInc;
                nextPk -= _2Dx;
            }

            nextPk += _2Dy;
        }

        return computedPoints;
    }

    private List<CustomPoint> computeHighSlopeLine() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        final int dy = this.point2.y() - this.point1.y();
        int dx = this.point2.x() - this.point1.x();
        int xInc = 1;

        if(dx < 0) {
            xInc = -1;
            dx = -dx;
        }

        final int _2Dy = 2 * dy;
        final int _2Dx = 2 * dx;

        int nextPk = _2Dx - dy;
        int x = this.point1.x();

        for(int y = this.point1.y(); y <= this.point2.y(); y++) {
            computedPoints.add(new CustomPoint(x, y));

            if(nextPk > 0) {
                x += xInc;
                nextPk -= _2Dy;
            }

            nextPk += _2Dx;
        }

        return computedPoints;
    }

    @Override
    public List<CustomPoint> computeLinePoints() {        
        this.sortPoints();

        return this.isHighSlope2() ?
            computeHighSlopeLine() :
            computeLowSlopeLine();
    }
    
}
