package PF.Playground;

public class NaivePairSumXXX {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        // int[][] arr = {{0,0}, {1,1}};
        int[][] arr2 = new int[2][5];

        int iPos=0, jPos=0;
        final int k = -2;

        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    jPos = j;
                    iPos = i;
                }
            }
        }

        System.out.printf("( %d , %d )", iPos, jPos);
        if (iPos > 0 && jPos > 0)
            System.out.printf(" = %d + %d = %d%n",
                arr[iPos], arr[jPos], k);
        else
            System.out.println();

    }
}


        // int[] arr = {0, -1, 2, -3, 1};
        // int iPos=0, jPos=0;
        // final int k = -2;

        // for (int i=0; i<arr.length; i++) {
        //     for (int j=i+1; j<arr.length; j++) {
        //         if (arr[i] + arr[j] == k) {
        //             jPos = j;
        //             iPos = i;
        //         }
        //     }
        // }

        // System.out.printf("( %d , %d )", iPos, jPos);
        // if (iPos > 0 && jPos > 0)
        //     System.out.printf(" = %d + %d = %d%n",
        //         arr[iPos], arr[jPos], k);
        // else
        //     System.out.println();
