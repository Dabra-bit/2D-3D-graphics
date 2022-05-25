package helpers;

public final class Matrixes {

    public static double[][] multiplyMatrix(
            int row1, int col1, double A[][],
            int row2, int col2, double B[][]) throws Exception {
        int i, j, k;

        // Check if multiplication is Possible
        if (row2 != col1) {
            throw new Exception("Multiplication Not Possible");
        }

        // Matrix to store the result
        // The product matrix will
        // be of size row1 x col2
        double C[][] = new double[row1][col2];

        // Multiply the two matrices
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }
}
