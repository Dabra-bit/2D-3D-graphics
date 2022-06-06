package points;

import helpers.Constants3D;
import helpers.Matrixes;

public class BasePoint3D {
    // ROTATION CONSTANTS
    public final static int ROTATION_X = 0;
    public final static int ROTATION_Y = 1;
    public final static int ROTATION_Z = 2;

    // Coords
    private double x;
    private double y;
    private double z;

    public BasePoint3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BasePoint3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BasePoint3D(double x, double y, double z, BasePoint3D vanishingPoint, int typeOfProjection) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public BasePoint3D(BasePoint3D p) {
        this.x = p.x();
        this.y = p.y();
        this.z = p.z();
    }

    public void setCoords(int[] coordsRowVector) {
        x = coordsRowVector[0];
        y = coordsRowVector[1];
        z = coordsRowVector[2];
    }

    public double x() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double y() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double z() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double[] toRowVector() {
        return new double[] { x, y, z };
    }

    public void print() {
        System.out.println(x + " " + y + " " + z);
    }

    public static BasePoint3D translate(BasePoint3D origin, int tx, int ty, int tz) {
        double[][] A = new double[][] {
                { 1, 0, 0, tx },
                { 0, 1, 0, ty },
                { 0, 0, 1, tz },
                { 0, 0, 0,  1 }
        };

        double[][] B = new double[][] {
                { origin.x() },
                { origin.y() },
                { origin.z() },
                { 1 }
        };

        try {
            double[][] C = Matrixes.multiplyMatrix(4, 4, A, 4, 1, B);
            
            int x = (int) Math.round(C[0][0]);
            int y = (int) Math.round(C[1][0]);
            int z = (int) Math.round(C[2][0]);

            return new BasePoint3D(x, y, z);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static BasePoint3D translate(BasePoint3D origin, double tx, double ty, double tz) {
        return translate(origin, (int) tx, (int) ty, (int) tz);
    }

    public static BasePoint3D scale(BasePoint3D origin, double sx, double sy, double sz) {
        double[][] A = new double[][] {
                { sx,  0,  0,  0 },
                {  0, sy,  0,  0 },
                {  0,  0, sz,  0 },
                {  0,  0,  0,  1 }
        };
        double[][] B = new double[][] {
                { origin.x() },
                { origin.y() },
                { origin.z() },
                { 1 }
        };

        try {
            double[][] C = Matrixes.multiplyMatrix(4, 4, A, 4, 1, B);

            int x = (int) Math.round(C[0][0]);
            int y = (int) Math.round(C[1][0]);
            int z = (int) Math.round(C[2][0]);

            return new BasePoint3D(x, y, z);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static BasePoint3D rotate(BasePoint3D origin, double aX, double aY, double aZ) {
        double[][] B = new double[][] {
                { origin.x() },
                { origin.y() },
                { origin.z() },
                { 1 }
        };

        double[][] Ax = getRotationMatrixOnX(aX);
        double[][] Ay = getRotationMatrixOnY(aY);
        double[][] Az = getRotationMatrixOnZ(aZ);

        try {
            double[][] C = Matrixes.multiplyMatrix(4, 4, Ax, 4, 4, Ay);
            C = Matrixes.multiplyMatrix(4, 4, C, 4, 4, Az);
            C = Matrixes.multiplyMatrix(4, 4, C, 4, 1, B);

            int x = (int) Math.round(C[0][0]);
            int y = (int) Math.round(C[1][0]);
            int z = (int) Math.round(C[2][0]);

            return new BasePoint3D(x, y, z);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static double[][] getRotationMatrixOnX(double theta) {
        double angle = Math.toRadians(theta);

        double sinTheta = Math.sin(angle);
        double cosTheta = Math.cos(angle);

        return new double[][] {
            { 1,    0,         0,     0 },
            { 0, cosTheta, -sinTheta, 0 },
            { 0, sinTheta, cosTheta,  0 },
            { 0,    0,         0,     1 }
        };
    }

    private static double[][] getRotationMatrixOnY(double theta) {
        double angle = Math.toRadians(theta);

        double sinTheta = Math.sin(angle);
        double cosTheta = Math.cos(angle);

        return new double[][] {
            { cosTheta,  0, sinTheta, 0 },
            {    0,      1,    0,     0 },
            { -sinTheta, 0, cosTheta, 0 },
            {    0,      0,    0,     1 }
        };
    }

    private static double[][] getRotationMatrixOnZ(double theta) {
        double angle = Math.toRadians(theta);

        double sinTheta = Math.sin(angle);
        double cosTheta = Math.cos(angle);

        return new double[][] {
            { cosTheta, -sinTheta, 0, 0 },
            { sinTheta, cosTheta,  0, 0 },
            {    0,        0,      1, 0 },
            {    0,        0,      0, 1 }
        };
    }

    public static CustomPoint to2D(BasePoint3D p, int typeOfProjection, BasePoint3D vanishingPoint) {
        double xTmp = 0;
        double yTmp = 0;

        double[][] A = {{p.x(), p.y(), p.z(), 1}};

        if(typeOfProjection == Constants3D.PARALLEL_PROJ) {

            double d1 = vanishingPoint.x();
            double d2 = vanishingPoint.y();
            double d3 = vanishingPoint.z();
            double[][] B = {
                {d3, 0, 0, 0},
                {0, d3, 0, 0},
                {-d1, -d2, 0, 0},
                {0, 0, 0, d3}
            };

            double[][] C = null;
            try {
                C = Matrixes.multiplyMatrix(1, 4, A, 4, 4, B);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            xTmp = Math.round(C[0][0]);
            yTmp = Math.round(C[0][1]);
        } else {
            xTmp = vanishingPoint.x() - (p.x() - vanishingPoint.x()) * vanishingPoint.z() / (p.z() - vanishingPoint.z());
            yTmp = vanishingPoint.y() - (p.y() - vanishingPoint.y()) * vanishingPoint.z() / (p.z() - vanishingPoint.z());
        }

        return new CustomPoint((int) xTmp, (int) yTmp);
    }
}
