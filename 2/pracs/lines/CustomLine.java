package lines;
import java.util.ArrayList;
import java.util.List;

import points.CustomPoint;

public class CustomLine implements CustomLineInterface{
    protected CustomPoint point1;
    protected CustomPoint point2;
    protected double slope;
    private double yIntercept;

    public CustomLine(CustomPoint point1, CustomPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public CustomPoint getPoint1() {
        return this.point1;
    }

    public void setPoint1(CustomPoint point) {
        this.point1 = point;
    }

    public CustomPoint getPoint2() {
        return this.point2;
    }

    public void setPoint2(CustomPoint point) {
        this.point2 = point;
    }

    public double getSlope() {
        return this.slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getYIntercept() {
        return this.yIntercept;
    }

    public void setYIntercept(double yIntercept) {
        this.yIntercept = yIntercept;
    }

    public boolean isHighSlope() {
        return Double.isNaN(this.slope) || Math.abs(this.slope) > 1;
    }
    
    protected void swapPoints() {
        CustomPoint temporalPoint = this.point1;
        this.point1 = this.point2;
        this.point2 = temporalPoint; 
    }

    protected CustomPoint[] sortPoints() {
        boolean typeOfSlope = this.isHighSlope();

        if(typeOfSlope == LOW_SLOPE && this.point1.x() > this.point2.x()) {
            this.swapPoints();
            return new CustomPoint[] {this.point2, this.point1};
        }
        
        if(typeOfSlope == HIGH_SLOPE && this.point1.y() > this.point2.y()) {
            this.swapPoints();
            return new CustomPoint[] {this.point2, this.point1};
        }

        return new CustomPoint[] {this.point1, this.point2};
    }

    private List<CustomPoint> computeLowSlopeLine() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        for(int x = this.point1.x(); x <= this.point2.x(); x++) {
            int y = (int) (this.slope * x + this.getYIntercept());
            computedPoints.add(new CustomPoint(x, y));
        }

        return computedPoints;
    }

    private List<CustomPoint> computeHighSlopeLine() {
        List<CustomPoint> computedPoints = new ArrayList<>();

        for(int y = this.point1.y(); y <= this.point2.y(); y++) {
            int x = Double.isNaN(this.slope) ?
                this.point1.x() :
                (int) ((y - this.getYIntercept()) / this.slope);

            computedPoints.add(new CustomPoint(x, y));
        }

        return computedPoints;
    }

    public List<CustomPoint> computeLinePoints() {
        int dy = this.point1.y() - this.point2.y();
        int dx = this.point1.x() - this.point2.x();

        this.setSlope(dx == 0 ?
            Double.NaN :
            dy / (double) dx
            );
        this.setYIntercept(Double.isNaN(this.slope) ? 
            0 :
            this.point1.y() - this.slope * this.point1.x()
            );
        this.sortPoints();
        
        return this.isHighSlope() ?
            this.computeHighSlopeLine() :
            this.computeLowSlopeLine();
    }
}
