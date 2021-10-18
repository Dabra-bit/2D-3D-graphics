package factories;

import circles.BasicCircle;
import circles.CustomCircle;
import points.CustomPoint;

public class CircleFactory {
    public static final int BASIC_CIRCLE = 1;
    public static final int POLAR_COORDS_CIRCLE = 2;
    public static final int DEFAULT_CIRCLE = BASIC_CIRCLE;

    public CustomCircle getCircle(CustomPoint center, int radius, int circleType) {
        if(circleType == 0) {
            circleType = DEFAULT_CIRCLE;
        }
        
        switch(circleType) {
            case BASIC_CIRCLE:
                return new BasicCircle(center, radius);
            case POLAR_COORDS_CIRCLE:
                return null;
            default:
                return null;
        }
    }
}
