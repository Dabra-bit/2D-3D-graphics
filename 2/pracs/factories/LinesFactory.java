package factories;

import lines.CustomLine;
import lines.LineEqCustomLine;
import lines.MiddlePointLine;
import lines.DDACustomLine;
import lines.BresenhamCustomLine;
import points.CustomPoint;

public class LinesFactory {
    public static final boolean[] DEFAULT_MASK = {true, true, true, true, true, true, true, true, true, true};
    public static final int LINE_EQ_LINE = 1;
    public static final int DDA_LINE = 2;
    public static final int BRESENHAM_LINE = 3;
    public static final int MIDDLE_POINT_LINE = 4;
    public static final int DEFAULT_LINE = BRESENHAM_LINE;

    public CustomLine getCustomLine(CustomPoint point1, CustomPoint point2, int lineType, boolean[] mask) {
        if(lineType == 0) {
            lineType = DEFAULT_LINE;
        }
        CustomLine line = null;

        switch (lineType) {
            case LINE_EQ_LINE:
                line = new LineEqCustomLine(point1, point2);
                break;
            case DDA_LINE:
                line = new DDACustomLine(point1, point2);
                break;
            case BRESENHAM_LINE:
                line = new BresenhamCustomLine(point1, point2);
                break;
            case MIDDLE_POINT_LINE:
                line = new MiddlePointLine(point1, point2);
                break;
            default:
                System.out.println("Line not found");
        }

        line.setMask(mask);
        return line;
    }
}
