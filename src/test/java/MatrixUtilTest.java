import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixUtilTest {

    MatrixUtil matrixUtil = new MatrixUtil();

    @Test
    public void shouldValidateIfAMatrixIsSquareMatrix() {
        float[][] sqareMatrix = {
                {1, 0},
                {0, 0}
        };

        boolean isSqareMatrix = matrixUtil.validateIfSquareMatrix(sqareMatrix);

        assertThat(isSqareMatrix, is(true));
    }

    @Test
    public void shouldNotValidateIfAMatrixIsNotASquareMatrix() {
        float[][] sqareMatrix = {
                {1, 0, 5},
                {0, 0, 8}
        };

        boolean isSqareMatrix = matrixUtil.validateIfSquareMatrix(sqareMatrix);

        assertThat(isSqareMatrix, is(false));
    }

    @Test
    public void shouldConvertMatrixIntoCorrectULMatrix() {
        float[][] inputMatrix = {
                {1, 1, 1},
                {4, 3, -1},
                {3, 5, 3}
        };
        float[][] expectedUMatrix = {
                {1, 1, 1},
                {0, -1, -5},
                {0, 0, -10}
        };
        float[][] expectedLMatrix = {
                {1, 0, 0},
                {4, 1, 0},
                {3, -2, 1}
        };

        LUMatrix luMatrix = matrixUtil.createLUMatrix(inputMatrix);

        assertThat(luMatrix.getUMatrix(), is(expectedUMatrix));
        assertThat(luMatrix.getLMatrix(), is(expectedLMatrix));
    }

    @Test
    public void shouldCreateAIdentityMatrixForGivenMatrixSize() {
        float[][] expectedIdentityMatrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        float[][] identityMatrix = matrixUtil.createIdentityMatrixOfSize(3);

        assertThat(identityMatrix, is(expectedIdentityMatrix));
    }

    @Test
    public void shouldSolveEquationAndCreateNewMatrixForUpperTraingleMatrix() {
        float[][] upperTraingleMatrix = {
                {1, 1, 1},
                {0, -1, -5},
                {0, 0, -10}
        };

        float[][] resultMatrix = {
                {1, 0, 0},
                {-4, 1, 0},
                {-11, 2, 1}
        };

        float[][] matrixBySolvingEquationOfUpperTriangleMatrix = matrixUtil.createMatrixBySolvingEquationOfUpperTriangleMatrix(upperTraingleMatrix, resultMatrix);

        float[][] expectedMatrixAfterSolving = {
                { 14/10F, 1/5F, -2/5F},
                { -15/10F, 0, 1/2F},
                { 11/10F, -1/5F, -1/10F}
        };

        assertThat(matrixBySolvingEquationOfUpperTriangleMatrix, is(expectedMatrixAfterSolving));
    }

    @Test
    public void shouldSolveEquationAndCreateNewMatrixForLowerTraingleMatrix() {
        float[][] lowerTraingleMatrix = {
                {1, 0, 0},
                {4, 1, 0},
                {3, -2, 1}
        };

        float[][] resultMatrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        float[][] matrixBySolvingEquationOfUpperTriangleMatrix = matrixUtil.createMatrixBySolvingEquationOfLowerTriangleMarix(lowerTraingleMatrix, resultMatrix);

        float[][] expectedMatrixAfterSolving = {
                {1, 0, 0},
                {-4, 1, 0},
                {-11, 2, 1}
        };

        assertThat(matrixBySolvingEquationOfUpperTriangleMatrix, is(expectedMatrixAfterSolving));
    }

}