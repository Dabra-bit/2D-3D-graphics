package points;

import helpers.Matrixes;

public class BasePoint3D {
    private int x;
    private int y;
    private int z;

    public BasePoint3D(int x, int y, int z) {
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

    public int x() {
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int y() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int z() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int[] toRowVector() {
        return new int[] { x, y, z };
    }

    public int[] translation(int tx, int ty, int tz) {
        double[][] A = new double[][] {
                { 1, 0, 0, tx },
                { 0, 1, 0, ty },
                { 0, 0, 1, tz },
                { 0, 0, 0, 1 }
        };

        double[][] B = new double[][] {
                { x },
                { y },
                { z },
                { 1 }
        };

        try {
            double[][] C = Matrixes.multiplyMatrix(4, 4, A, 4, 1, B);
            return new int[] { (int) C[0][0], (int) C[1][0], (int) C[2][0] };
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
