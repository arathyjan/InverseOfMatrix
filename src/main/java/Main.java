public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        float[][] inputMatrix = m.getInputMatrix();

        m.printMatrix(inputMatrix);

        MatrixInverseCalculator matrixInverseCalculator = new MatrixInverseCalculator();

        float[][] inverseOfMatrix = matrixInverseCalculator.calculateInverse(inputMatrix);

        m.printMatrix(inverseOfMatrix);
    }

    private void printMatrix(float[][] matrix) {
        System.out.println("{");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            System.out.print("{");
            for( int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if(j+1 < matrix[i].length) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
        }
        System.out.println("}");
    }

    public float[][] getInputMatrix() {
        float[][] inputMatrix = {
                {1, 1, 1},
                {4, 3, -1},
                {3, 5, 3}
        };

        return inputMatrix;
    }
}
