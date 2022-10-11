package submit;

import java.util.Scanner;

public class ProFun08_Q3_65988 {
    public static void main(String[] args) {
        // int data[] = new int[10];
        int[] data = {5,3,8,4,10,3,1,5,9,7,2,0};//input data

        Scanner sc = new Scanner(System.in);
        for (int i=0; i<10; i++) {
            System.out.print("Enter input :");
            // data[i] = sc.nextInt();
        }
        topK(data);
        sc.close();
    }

    static void topK(int [] intArr){
        int n = 10;
        int [] arr = new int[n];
        for (int curIdx = 0;curIdx < intArr.length;curIdx++){
            int input = intArr[curIdx];
            System.out.println("Input received : " + input);

            if(input <= 0)
                break;
            int leastGreater = Integer.MAX_VALUE;
            int insertIdx = arr.length;

            //check index to insert
            // todo 1 : find least & insert after (append)
            for (int i = 0;i < arr.length;i++){
                if(arr[i] > input && arr[i] <= leastGreater){
                    leastGreater = arr[i];
                    insertIdx = i+1;
                }
            }
            // todo 2 : Shift right and delete overflower
            if(leastGreater != arr[arr.length-1]){
                insertIdx = (insertIdx == arr.length) ? 0 : insertIdx;//check if have no greater value number
                //move and insert
                for (int j = arr.length-1; j > insertIdx; j--) {
                    arr[j] = arr[j-1];
                }
                // * newest index
                arr[insertIdx] = input;
            }

            // ? print inserted Array every time you input new value
            System.out.print("[");
            for(int i = 0;i < arr.length;i++){
                System.out.print(arr[i] + ",");
            }
            System.out.println("\b]\n");
        };
        return;
    }
}

