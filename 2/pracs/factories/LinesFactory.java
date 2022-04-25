package factories;

import lines.CustomLine;
import lines.LineEqCustomLine;
import lines.MiddlePointLine;
import lines.DDACustomLine;
import lines.BresenhamCustomLine;
import points.CustomPoint;

public class LinesFactory {
    public static final int LINE_EQ_LINE = 1;
    public static final int DDA_LINE = 2;
    public static final int BRESENHAM_LINE = 3;
    public static final int MIDDLE_POINT_LINE = 4;
    public static final int DEFAULT_LINE = BRESENHAM_LINE;

    public CustomLine getCustomLine(CustomPoint point1, CustomPoint point2, int lineType) {
        if(lineType == 0) {
            lineType = DEFAULT_LINE;
        }

        switch (lineType) {
            case LINE_EQ_LINE:
                return new LineEqCustomLine(point1, point2);
            case DDA_LINE:
                return new DDACustomLine(point1, point2);
            case BRESENHAM_LINE:
                return new BresenhamCustomLine(point1, point2);
            case MIDDLE_POINT_LINE:
                return new MiddlePointLine(point1, point2);
            default:
                return null;
        }        
    }
}
