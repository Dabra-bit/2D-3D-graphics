package helpers;

import points.BasePoint3D;

public final class Constants3D {
    public final static int PARALLEL_PROJ = 0;
    public final static int PERSPECTIVE_PROJ = 1;
    public final static int DEF_PROJECTION = PARALLEL_PROJ;
    public final static BasePoint3D DEF_PARALLEL_PROJ_P = new BasePoint3D(100000000, 100000000, 100000000);
    public final static BasePoint3D DEF_PERSPECTIVE_PROJ_P = new BasePoint3D(1000, 1000, 1000);
    public final static BasePoint3D DEF_PROJ_P = DEF_PARALLEL_PROJ_P;
}
