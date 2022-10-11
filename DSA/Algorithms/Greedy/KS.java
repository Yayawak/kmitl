
class Knapsack {
    public static void main(String[] args) {
        int object, m, C;
        System.out.println("Enter the Total Objects");
        // object = sc.nextInt();
        int n = 4;
        int[] profit = {20, 30, 50, 10};
        int[] weight = {2, 5, 10, 5};
        m = C = 16;
        double p_w[] = new double[n];
        for (int i = 0; i < n; i++) {
            p_w[i] = (double) profit[i] / (double) weight[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p_w[i] < p_w[j]) {
                    double temp = p_w[j];
                    p_w[j] = p_w[i];
                    p_w[i] = temp;

                    int temp1 = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp1;

                    int temp2 = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp2;
                }
            }
        }
        int k = 0;
        double sum = 0;
        System.out.println();
        // while (C > 0) {
        // m = C = 16
        while (m > 0) {
            if (weight[k] < m) {
                sum += 1 * profit[k];
                // m = m - weight[k];
                m -= weight[k];
            } else {
                double x6 = m*profit[k] / weight[k];
                // System.out.println(x6);
                sum += x6;
                m = 0;
            }
            System.out.println(sum);
            k++;
        }
        System.out.println("Final Profit is=" + sum);
    }
}
