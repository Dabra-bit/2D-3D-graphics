package lines;
import java.util.ArrayList;
import java.util.List;

import points.CustomPoint;

public abstract class CustomLine {
    public static final boolean LOW_SLOPE = false;
    public static final boolean HIGH_SLOPE = true;

    protected CustomPoint point1;
    protected CustomPoint point2;
    protected boolean[] mask;

    protected CustomLine(CustomPoint point1, CustomPoint point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public boolean isHighSlope() {
        int dx = this.point1.x() - this.point2.x();
        int dy = this.point1.y() - this.point2.y();

        double slope = dx == 0 ?
            Double.NaN :
            dy / (double) dx;
        return Double.isNaN(slope) || Math.abs(slope) > 1;
    }

    public abstract List<CustomPoint> computeLinePoints();

    public List<CustomPoint> makeLineThicker(int thick, List<CustomPoint> points) {
        List<CustomPoint> computedPoints = new ArrayList<>();
        boolean hs = isHighSlope();
        int extra = thick / 2;

        for(CustomPoint p : points) {
            int extraup = extra;
            int extradown = thick%2 != 0 ? extra : extra-1;
            computedPoints.add(p);

            if(hs) {
                while(extraup > 0) computedPoints.add(new CustomPoint(p.x()+extraup--, p.y()));
                while(extradown > 0) computedPoints.add(new CustomPoint(p.x()-extradown--, p.y()));
            } else {
                while(extraup > 0) computedPoints.add(new CustomPoint(p.x(), p.y()+extraup--));
                while(extradown > 0) computedPoints.add(new CustomPoint(p.x(), p.y()-extradown--));
            }
        }
        return computedPoints;
    }

    public void setMask(boolean[] mask) {
        this.mask = mask;
    }

    public List<CustomPoint> filterLine(List<CustomPoint> points) {
        int i = 0;
        List<CustomPoint> filtered = new ArrayList<>();

        for(CustomPoint p : points) {
            if(mask[i++%10] == true) {
                filtered.add(p);
            }
        }

        return filtered;
    }
}
