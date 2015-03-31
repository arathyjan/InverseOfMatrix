import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixInverseCalculatorTest {

    @Test
    public void shouldCheckIfWeGetInverseOfMatrix() {

        MatrixInverseCalculator matrixInverseCalculator = new MatrixInverseCalculator();

        float[][] inputMatrix = {
                { 1, 1, 1},
                { 4, 3, -1},
                { 3, 5, 3}
        };

        float[][] expectedMatrix = {
                { 14/10F, 1/5F, -2/5F},
                { -15/10F, 0F, 1/2F},
                { 11/10F, -1/5F, -1/10F}
        };

        float[][] outputMatrix = matrixInverseCalculator.calculateInverse(inputMatrix);
        
        assertThat(outputMatrix, is(expectedMatrix));
    }

}