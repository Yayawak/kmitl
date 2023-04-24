public class Matrix {
    private int[][] matrix;
    private int col;
    private int row;

    public Matrix(int col, int row) {
        this.col = col;
        this.row = row;
        matrix = new int[row][col];
    }

    public Matrix(int[]... rows) {
        // Check if all rows have the same column length
        int firstRowLength = rows[0].length;
        for (int i = 1; i < rows.length; i++) {
            if (rows[i].length != firstRowLength) {
                throw new IllegalArgumentException("All rows must have the same length");
            }
        }

        this.row = rows.length;
        this.col = firstRowLength;
        matrix = new int[this.row][this.col];

        for (int i = 0; i < rows.length; i++) {
            matrix[i] = rows[i];
        }
    }

    public boolean isSquareMatrix() {
        return row == col;
    }

    public boolean canMultiply(Matrix m) {
        return this.col == m.row;
    }

    public Matrix matMul(Matrix that) {
        if (!canMultiply(that)) {
            throw new IllegalArgumentException("These two matrices cannot be multiplied");
        }

        Matrix ret = new Matrix(this.col, that.row);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < that.col; j++) {
                int sum = 0;
                for (int k = 0; k < this.col; k++) {
                    sum += this.matrix[i][k] * that.matrix[k][j];
                }
                ret.matrix[i][j] = sum;
            }
        }

        return ret;
    }

    public static Matrix identityMatrix(int size) {
        Matrix ret = new Matrix(size, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    ret.matrix[i][j] = 1;
                } else {
                    ret.matrix[i][j] = 0;
                }
            }
        }

        return ret;
    }

    public Matrix power(int n) {
        if (!isSquareMatrix()) {
            throw new IllegalArgumentException("Matrix must be square in order to be raised to a power");
        } else if (n < 0) {
            throw new IllegalArgumentException("Power must be a non-negative integer");
        }

        Matrix result = identityMatrix(this.row);
        Matrix base = new Matrix(this.matrix);

        while (n > 0) {
            if (n % 2 == 1) {
                result = result.matMul(base);
            }
            base = base.matMul(base);
            n = n / 2;
        }

        return result;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
