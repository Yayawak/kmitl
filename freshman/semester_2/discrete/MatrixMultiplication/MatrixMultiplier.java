import java.util.Scanner;

public class MatrixMultiplier {
    private Scanner sc;
    public MatrixMultiplier() {
        sc = new Scanner(System.in);
    }

    public void startProgram() {
        Matrix m = createMatrixFromInput();
        System.out.println(m);
        int n = InputReciever.getIntInput("Enter power of matrix : ");
        System.out.println(m.power(n));
    }

    private Matrix createMatrixFromInput() {
        int col = InputReciever.getIntInput("Enter number of columns : ");
        int row = InputReciever.getIntInput("Enter number of rows : ");
        Matrix tmp = new Matrix(col, row);
        for (int i = 0; i < col; i++) {
            tmp.getMatrix()[i] = InputReciever.getIntArrInput("Enter elements of row " + i + " : ", col);
        }
        return tmp;
    }

    private void init() {
        // Matrix A = new Matrix(3, 4);
        Matrix A = new Matrix(
            new int[]{1, 2, 1, 2},
            new int[]{1, 2, 1, 2},
            new int[]{1, 2, 1, 2}
        );
        // Matrix B = new Matrix(4, 3);
        Matrix B = new Matrix(
            new int[]{3, 3, 3},
            new int[]{3, 3, 3},
            new int[]{3, 3, 3},
            new int[]{3, 3, 3}
        );
        Matrix C = new Matrix(
            new int[]{1, 5, 10},
            new int[]{0, 2, 7},
            new int[]{9, 4, 3}
        );

        // System.out.println(A);
        // System.out.println(B);
        // System.out.println("Is A can multiply B : " + A.canMultiply(B));

        // System.out.println(A.matMul(B));
        // System.out.println(C.matMul(C));
        // System.out.println(I.matMul(I));
        // System.out.println(A.matMul(
            // Matrix.identityMatrix(A.getCol())
            // Matrix.identityMatrix(4)
        // ));
        MatrixV0 I = MatrixV0.identityMatrix(4);
        System.out.println(C);
        // System.out.println(C.power(5));
    }
}
