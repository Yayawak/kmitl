import javax.sql.RowSet;
// java.awt.dnd
// java.security

public class MatrixV0 {
    private int[][] matrix;
    private int col;
    private int row;

    public MatrixV0(int col, int row) {
        this.col = col;
        this.row = row;
        matrix = new int[row][col];
    }

    public MatrixV0(int[]... rows) {
        boolean isAllSameColumnLength = true;
        for (int i = 0; i < rows.length - 1; i++)
            if (rows[i] != rows[i + 1])
                isAllSameColumnLength = false;
        if (isAllSameColumnLength)
            try {
                throw new Exception("provided rows must have all same column lenght");
            } catch (Exception e) { e.printStackTrace(); }

        this.row = rows.length;
        this.col = rows[0].length;
        matrix = new int[this.row][this.col];
        for (int i = 0; i < rows.length; i++)
            matrix[i] = rows[i];
    }

    public boolean isSquareMatrix() {
        return row == col;
    }

    public boolean canMultiply(MatrixV0 m) {
        return this.col == m.row;
    }

    public MatrixV0 matMul(MatrixV0 that) {
        if (!canMultiply(that)) {
            System.out.println("these 2 matrixs can not be multiplied.");
            return null;
        }
        MatrixV0 ret = new MatrixV0(this.row, this.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < that.col; j++) {
                int sum = 0;
                for (int k = 0; k < this.col; k++) {
                    int a = matrix[i][k];
                    int b = that.matrix[k][j];
                    sum += (a * b);
                }
                ret.matrix[i][j] = sum;
            }
        }
        return ret;
    }

    public static MatrixV0 identityMatrix(int size) {
        MatrixV0 ret = new MatrixV0(size, size);
        ret.matrix = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                ret.matrix[i][j] = i == j ? 1 : 0;
        return ret;
    }

    public MatrixV0 power(int n) {
        if (!isSquareMatrix()) {
            System.out.println("Must be sqaure matrix inorder to Power.");
            return null;
        } else if (n < 0) {
            System.out.println("power must be non negative integer.");
            return null;
        }
        for (int i = 0; i < n; i++) {
            this.matrix = matMul(this).matrix;
        }
        return this;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = matrix[i][j];
                sb.append(val);
                if (j != col - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

}
