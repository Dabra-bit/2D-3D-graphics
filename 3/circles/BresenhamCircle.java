package circles;

import java.util.List;
import java.util.ArrayList;

import points.CustomPoint;

public class BresenhamCircle extends CustomCircle {

    public BresenhamCircle(CustomPoint center, int radius) {
        super(center, radius);
    }

    @Override
    public List<CustomPoint> computeFigurePoints() {
        List<CustomPoint> computedPoints = new ArrayList<>();
        int dp = 3 - 2 * radius;
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
            
            x++;
            if (dp > 0) {
                y--;
                dp += 4 * (x - y) + 10;
            } else dp += 4 * x + 6;
        }
        
        return computedPoints;
    }
    
}
