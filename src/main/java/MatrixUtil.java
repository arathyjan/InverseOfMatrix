public class MatrixUtil {

    public boolean validateIfSquareMatrix(float[][] inputMatrix) {
        return inputMatrix.length == 0 || inputMatrix[0].length == inputMatrix.length;
    }

    public LUMatrix createLUMatrix(float[][] inputMatrix) {
        int n = inputMatrix.length;

        float[][] uMatrix = inputMatrix;
        float[][] lMatrix = createIdentityMatrixOfSize(n);

        for(int i = 1; i < n; i++) {
           for(int j = 0; j < i; j++) {
               float factor = uMatrix[i][j]/uMatrix[j][j];
               lMatrix[i][j] = factor;
               for(int k = 0; k < n; k++) {
                    uMatrix[i][k] = uMatrix[i][k] - factor * uMatrix[j][k];
               }
           }
        }

        LUMatrix luMatrix = new LUMatrix();
        luMatrix.setUMatrix(uMatrix);
        luMatrix.setLMatrix(lMatrix);

        return luMatrix;
    }

    public float[][] createIdentityMatrixOfSize(int matrixSize) {
        float [][]lMatrix = new float[matrixSize][matrixSize];
        for(int i = 0;i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                if(i == j) {
                    lMatrix[i][j] = 1;
                }
            }
        }
        return lMatrix;
    }

    public float[][] createMatrixBySolvingEquationOfLowerTriangleMarix(float[][] lMatrix, float[][] resultMatrix) {
        int n = lMatrix.length;

        float[][] solvedEquation = new float[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    float sumValue = 0;

                    for (int k = 0; k < n; k++) {
                        sumValue += lMatrix[j][k] * solvedEquation[k][i];
                    }

                    solvedEquation[j][i] = (resultMatrix[j][i] - sumValue) / lMatrix[j][j];
                }
        }

        return solvedEquation;
    }

    public float[][] createMatrixBySolvingEquationOfUpperTriangleMatrix(float[][] uMatrix, float[][] resultMatrix) {
        int n = uMatrix.length;

        float[][] solvedEquation = new float[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = n-1; j >= 0; j--) {

                float sumValue = 0;

                for (int k = 0; k < n; k++) {
                    sumValue += uMatrix[j][k] * solvedEquation[k][i];
                }

                solvedEquation[j][i] = (resultMatrix[j][i] - sumValue) / uMatrix[j][j];
                if(Math.abs(solvedEquation[j][i]) == 0) {
                    solvedEquation[j][i] = 0;
                }
            }
        }

        return solvedEquation;
    }
}
