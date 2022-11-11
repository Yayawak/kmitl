import java.util.Scanner;

public class AC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        if (0 < N && N <= 100) {
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int y = sc.nextInt();

            int k = sc.nextInt();
            int[] check = new int[k];

            for (int j = 0; j < k; j++)
                check[j] = sc.nextInt();

            int count = 0;
            for (int z = 0; z < check.length; z++) {
                for (int s = 0; s < arr.length; s++) {
                    int year = y + arr[s] - 1;

                    if (check[z] - year >= 1) {
                        count++;

                        if (count == 1) {
                            System.out.print(s + 1);
                        } else if (count > 1) {
                            System.out.print(" " + (s + 1));
                        }
                    }

                }

                if (count == 0) {
                    System.out.print("full");
                }

                count = 0;
                System.out.print('\n');

            }

        }
        sc.close();

    }
}
