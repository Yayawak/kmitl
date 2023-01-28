public class KnapsackBruteForce {
    public static void main(String[] args) {
        int[] values = { 20, 30, 50, 10 };
        int[] weights = { 2, 5, 10, 5 };
        int C = 16, n = 4;
        int maxVal = getMaxVal(n, weights, values,
            C, 0);
        System.out.println(maxVal);
    }
    static int getMaxVal(int n, int w[], int v[],
        int c, int i) {
            // optimization
            int u = 40;
            int topdown[][] = new int[u][u];

            int vin, vex;
            if(i==n || c==0) return 0;
            if(topdown[i][c] > 0 ) {
                return topdown[i][c];
            }
            if(w[i] < c) {
                vin = getMaxVal(n, w, v, c-w[i], i+1) + v[i];
                vex = getMaxVal(n, w, v, c, i+1);

                int max = (vin>vex) ? vin : vex;
                topdown[i][c] = max;
                // return max;
            }
            else{
                vex = getMaxVal(n, w, v, c, i+1);
                topdown[i][c] = vex;
                // return vex;
            }
            return topdown[i][c];
    }
}
