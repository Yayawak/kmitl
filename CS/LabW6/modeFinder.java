package CS.LabW6;

public class modeFinder {
    public static void main(String[] args) {
        // int[] arr = {1,2,1,4,2,5,2,7};
        int[] arr = {1,1,2,2,2,4,5,7};
        int maxCnt = 0;
        int arrSize = arr.length; // 8
        int k = 0;
        int ans=Integer.MIN_VALUE, secret=Integer.MIN_VALUE, m=0;
        for (int i=0; i<arrSize; i++) {
            int cnt = 0;
            // check again and see if the same element appears
            for (int j=0; j<arrSize; j++) {
                if(arr[i] == arr[j]) {
                    cnt++;
                    k++;
                }
            }


            // ในการวนใหญ่แต่ละครั้งจะต้อง เช็คสิ่งนี้
            if(cnt>maxCnt) {
                maxCnt = cnt;
                ans = arr[i];
                secret = i; // ?? first number appear (currentMode)
                m++;
            }
        }
        System.out.println(ans + " " + maxCnt);
        secret += k+m;
        // secret += (k+m);
        System.out.println(secret);

        int sum=0;
        for(int x : arr) {
            sum+=x;
        }
        System.out.println(sum);
    }
}
