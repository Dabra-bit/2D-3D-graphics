package circles;

import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class MiddlePointCircle extends CustomCircle {

    public MiddlePointCircle(CustomPoint center, int radius) {
        super(center, radius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();
        int pk = 1 - radius;
        int cX = center.x();
        int cY = center.y();
        
        int x = 0;
        int y = radius;

        while(x <= y) {
            computedPoints.add(new CustomPoint(cX + x, cY +  y));
            computedPoints.add(new CustomPoint(cX + x, cY - y));
            computedPoints.add(new CustomPoint(cX - x, cY +  y));
            computedPoints.add(new CustomPoint(cX - x, cY - y));
            computedPoints.add(new CustomPoint(cX + y, cY + x));
            computedPoints.add(new CustomPoint(cX - y, cY + x));
            computedPoints.add(new CustomPoint(cX + y, cY - x));
            computedPoints.add(new CustomPoint(cX - y, cY - x));
            
            if(pk < 0) {
                pk += 2 * x + 3;
                x++;
            } else {
                pk += 2 * x - 2 * y + 5;
                x++; y--;
            }
        }
        
        return computedPoints;
    }
    
}
