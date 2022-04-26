package factories;

import circles.BasicCircle;
import circles.PolarCoordsCircle;
import circles.CustomCircle;
import circles.EightSidedCircle;
import circles.MiddlePointCircle;
import circles.BresenhamCircle;
import points.CustomPoint;

public class CircleFactory {
    public static final int BASIC_CIRCLE = 1;
    public static final int POLAR_COORDS_CIRCLE = 2;
    public static final int EIGHT_SIDED_CIRCLE = 3;
    public static final int MIDDLE_POINT_CIRCLE = 4;
    public static final int BRESENHAM_CIRCLE = 5;
    public static final int DEFAULT_CIRCLE = BRESENHAM_CIRCLE;

    public CustomCircle getCircle(CustomPoint center, int radius, int circleType) {
        if(circleType == 0) {
            circleType = POLAR_COORDS_CIRCLE;
        }
        
        switch(circleType) {
            case BASIC_CIRCLE:
                return new BasicCircle(center, radius);
            case POLAR_COORDS_CIRCLE:
                return new PolarCoordsCircle(center, radius);
            case EIGHT_SIDED_CIRCLE:
                return new EightSidedCircle(center, radius);
            case MIDDLE_POINT_CIRCLE:
                return new MiddlePointCircle(center, radius);
            case BRESENHAM_CIRCLE:
                return new BresenhamCircle(center, radius);
            default:
                return null;
        }
    }
}
