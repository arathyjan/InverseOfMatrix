public class MatrixInverseCalculator {

    public float[][] calculateInverse(float[][] inputMatrix) {
        MatrixUtil matrixUtil = new MatrixUtil();

        boolean validSquareMatrix = matrixUtil.validateIfSquareMatrix(inputMatrix);

        if(validSquareMatrix) {
            LUMatrix luMatrix = matrixUtil.createLUMatrix(inputMatrix);

            float[][] identityMatrix = matrixUtil.createIdentityMatrixOfSize(inputMatrix.length);
            float[][] solvedMatrixFromLowerTraingleAndIdentityMatrix = matrixUtil.createMatrixBySolvingEquationOfLowerTriangleMarix(luMatrix.getLMatrix(), identityMatrix);
            float[][] finalResult = matrixUtil.createMatrixBySolvingEquationOfUpperTriangleMatrix(luMatrix.getUMatrix(), solvedMatrixFromLowerTraingleAndIdentityMatrix);
            return finalResult;
        }

        return new float[0][];
    }
}
