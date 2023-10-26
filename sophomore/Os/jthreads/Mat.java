import java.util.Arrays;

public class Mat {
    public static void main(String[] args) {
        int[][] inputA = {{5,6,7}, {4, 8, 9}};
        int[][] inputB = {{6, 4}, {5, 7}, {1, 1}};
        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);
        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r, matC_c);

        matA.show();
        matB.show();


        // Thread[] threads = new Thread[matC_r * matC_c];
        for (int i = 0; i < matC_r * matC_c; i++)
        {
            // System.out.println("(r, c) = " + i / matC_c + "," + i % matC_c);
            Runnable MMT = new MatMulThread(
                i / matC_c,
                i % matC_c,
            matA, matB, matC);
            Thread t = new Thread(MMT);
            // threads[i]
            try {
                t.join();
            } catch (Exception e) { System.out.println(e); }
            t.start();
        }
        
        matC.show();
    }
}


class MyData
{
    public int[][] data;

    public MyData(int[][] mat)
    {
        this.data = mat; 
    }

    public MyData(int r, int c)
    {
        data = new int[r][c];
        for (int[] row : data)
        {
            // idiot
            // Arrays.fill(row, 9);
        }
    }

    public void show()
    {
        // System.out.println(Arrays.deepToString(data));

        System.out.println("printing matrix");
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class MatMulThread implements Runnable
{
    int processingRow;
    int processingCol;
    MyData A, B, C;

    public MatMulThread(int processingRow, int processingCol,
        MyData A, MyData B, MyData C)
    {
        this.processingRow = processingRow;
        this.processingCol = processingCol;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void run() {
        // System.out.println("before out of bound = " + A.data[0].length);
        for (int i = 0; i < A.data[0].length; i++)
        {
            C.data[processingRow][processingCol]
                += A.data[processingRow][i] * B.data[i][processingCol];
        }
    }

}