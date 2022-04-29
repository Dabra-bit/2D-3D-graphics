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

    public CustomCircle getCircle(CustomPoint center, int radius, int circleType, boolean[] mask) {
        if (circleType == 0) {
            circleType = DEFAULT_CIRCLE;
        }

        CustomCircle circle = null;

        switch (circleType) {
            case BASIC_CIRCLE:
                circle = new BasicCircle(center, radius);
                break;
            case POLAR_COORDS_CIRCLE:
                circle = new PolarCoordsCircle(center, radius);
                break;
            case EIGHT_SIDED_CIRCLE:
                circle = new EightSidedCircle(center, radius);
                break;
            case MIDDLE_POINT_CIRCLE:
                circle = new MiddlePointCircle(center, radius);
                break;
            case BRESENHAM_CIRCLE:
                circle = new BresenhamCircle(center, radius);
                break;
            default:
                System.out.println("Line not found");
                return null;
        }
        circle.setMask(mask);
        return circle;
    }
}
