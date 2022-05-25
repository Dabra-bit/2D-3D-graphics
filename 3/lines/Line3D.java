package lines;

import points.BasePoint3D;
import points.CustomPoint;

public class Line3D {
    public final static int PARALLEL_PROJ = 0;
    public final static int PERSPECTIVE_PROJ = 1;
    public final static int DEF_PROJECTION = PARALLEL_PROJ;
    public final static BasePoint3D DEF_PARALLEL_PROJ_P = new BasePoint3D(100000000, 100000000, 100000000);
    public final static BasePoint3D DEF_PERSPECTIVE_PROJ_P = new BasePoint3D(1000, 1000, 1000);
    public final static BasePoint3D DEF_PROJ_P = DEF_PARALLEL_PROJ_P;

    private BasePoint3D p1;
    private BasePoint3D p2;
    private BasePoint3D vanishingPoint;
    private int projectionType;
    private CustomPoint _p1;
    private CustomPoint _p2;

    public Line3D(BasePoint3D p1, BasePoint3D p2) {
        this.p1 = p1;
        this.p2 = p2;
        projectionType = DEF_PROJECTION;
        vanishingPoint = DEF_PARALLEL_PROJ_P;

        transform();
    }

    public Line3D(BasePoint3D p1, BasePoint3D p2, int projectionType, BasePoint3D vanishingPoint) {
        this.p1 = p1;
        this.p2 = p2;
        this.projectionType = projectionType;

        if(vanishingPoint == null) {
            this.vanishingPoint = projectionType == PARALLEL_PROJ ? DEF_PARALLEL_PROJ_P : DEF_PERSPECTIVE_PROJ_P;
        } else {
            this.vanishingPoint = vanishingPoint;
        }

        transform();
    }

    private void transform() {
        int p1_x = 0;
        int p1_y = 0;
        int p2_x = 0;
        int p2_y = 0;

        if(projectionType == PARALLEL_PROJ) {
            p1_x = p1.x() - vanishingPoint.x() * p1.z() / vanishingPoint.z();
            p1_y = p1.y() - vanishingPoint.y() * p1.z() / vanishingPoint.z();
            p2_x = p2.x() - vanishingPoint.x() * p2.z() / vanishingPoint.z();
            p2_y = p2.y() - vanishingPoint.y() * p2.z() / vanishingPoint.z();
        } else {
            p1_x = vanishingPoint.x() - (p1.x() - vanishingPoint.x()) * vanishingPoint.z() / (p1.z() - vanishingPoint.z());
            p1_y = vanishingPoint.y() - (p1.y() - vanishingPoint.y()) * vanishingPoint.z() / (p1.z() - vanishingPoint.z());
            p2_x = vanishingPoint.x() - (p2.x() - vanishingPoint.x()) * vanishingPoint.z() / (p2.z() - vanishingPoint.z());
            p2_y = vanishingPoint.y() - (p2.y() - vanishingPoint.y()) * vanishingPoint.z() / (p2.z() - vanishingPoint.z());
        }

        _p1 = new CustomPoint(p1_x, p1_y);
        _p2 = new CustomPoint(p2_x, p2_y);
    }

    public CustomPoint[] getPoints() {
        return new CustomPoint[]{ _p1, _p2 };
    }
}
