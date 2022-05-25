package circles;

import java.util.ArrayList;
import java.util.List;

import points.CustomPoint;

public abstract class CustomCircle {

    public static final int DEFAULT_THICKNESS = 1;
    public static final boolean[] DEFAULT_MASK = { true, true, true, true, true, true, true, true, true, true };

    protected CustomPoint center;
    protected int radius;
    protected boolean[] mask;

    protected CustomCircle(CustomPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public abstract List<CustomPoint> computeFigurePoints();

    public List<CustomPoint> filterCircle(List<CustomPoint> pointsToDraw) {
        List<CustomPoint> ans = new ArrayList<>();

        for (int i = 0; i < pointsToDraw.size(); i += 8) {
            for (int j = i; j < i + 4 && j < pointsToDraw.size(); j++) {
                if (mask[j % 10] == true) {
                    ans.add(pointsToDraw.get(j));
                }
            }
            for (int j = i + 4; j < i + 8 && j < pointsToDraw.size(); j++) {
                if (mask[9 - (j % 10)] == true) {
                    ans.add(pointsToDraw.get(j));
                }
            }
        }
        return ans;
    }

    public static List<CustomPoint> makeCircleThicker(int thick, List<CustomPoint> pointsToDraw) {
        List<CustomPoint> ans = new ArrayList<>();

        for (CustomPoint p : pointsToDraw) {
            for (int i = p.y(); i < p.y() + thick; i++) {
                for (int j = p.x(); j < p.x() + thick; j++) {
                    ans.add(new CustomPoint(j, i));
                }
            }
        }

        return ans;
    }

    public void setMask(boolean[] mask) {
        this.mask = mask;
    }
}
