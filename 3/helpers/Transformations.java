package helpers;

public final class Transformations {
    public final static int ROTATION_X = 0;
    public final static int ROTATION_Y = 1;
    public final static int ROTATION_Z = 2;

    public static int[] translation(int a[], int tx, int ty, int tz) {
        double[][] A = new double[][] {
                { 1, 0, 0, tx },
                { 0, 1, 0, ty },
                { 0, 0, 1, tz },
                { 0, 0, 0, 1 }
        };

        double[][] B = new double[][] {
                { a[0] },
                { a[1] },
                { a[2] },
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

    public static int[] rotation(int a[], int axis, double theta) {
        double angle = Math.toRadians(theta);

        double[][] B = new double[][] {
                { a[0] },
                { a[1] },
                { a[2] },
                { 1 }
        };

        double sinTheta = Math.sin(angle);
        double cosTheta = Math.cos(angle);

        double[][] A = null;
        if (axis == ROTATION_Z) {
            A = new double[][] {
                    { cosTheta, -sinTheta, 0, 0 },
                    { sinTheta, cosTheta, 0, 0 },
                    { 0, 0, 1, 0 },
                    { 0, 0, 0, 1 }
            };
        } else if (axis == ROTATION_Y) {
            A = new double[][] {
                    { cosTheta, 0, sinTheta, 0 },
                    { 0, 1, 0, 0 },
                    { -sinTheta, 0, cosTheta, 0 },
                    { 0, 0, 0, 1 }
            };
        } else if (axis == ROTATION_X) {
            A = new double[][] {
                    { 1, 0, 0, 0 },
                    { 0, cosTheta, -sinTheta, 0 },
                    { 0, sinTheta, cosTheta, 0 },
                    { 0, 0, 0, 1 }
            };
        } else {
            return null;
        }

        try {
            double[][] C = Matrixes.multiplyMatrix(4, 4, A, 4, 1, B);
            return new int[] { (int) C[0][0], (int) C[1][0], (int) C[2][0] };
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int[] scaling(int a[], double sx, double sy, double sz) {
        double[][] A = new double[][] {
                { sx, 0, 0, 0 },
                { 0, sy, 0, 0 },
                { 0, 0, sz, 0 },
                { 0, 0, 0, 1 }
        };
        double[][] B = new double[][] {
                { a[0] },
                { a[1] },
                { a[2] },
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
