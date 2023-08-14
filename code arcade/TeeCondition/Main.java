// package TeeCondition;
import java.util.Scanner;

import BreathTechiquePermuation.Main;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public int[] getTrioInput()
    {
        System.out.println("Enter a b c sep by space");
        // String line = sc.nextLine();
        // System.out.println(line);

        // String parts[] = line.split("\\s+");
        // System.out.println(parts[0].charAt(0));
        // for (int i = 0; i < parts.length; i++)
            // System.out.println(parts[i] + " : ");
        int arr[] = new int[3];
        for (int i = 0; i < arr.length; i++)
        {
            // if (i <= 1) // a b
            // {
                // constraint
            // }
            arr[i] = sc.nextInt();
        }
        // arr[0] = Integer.valueOf(parts[0]);
        // arr[1] = Integer.valueOf(parts[1]);
        // arr[2] = Integer.valueOf(parts[2]);

        // arr[0] = Integer.valueOf(line.charAt(0));
        // arr[1] = Integer.valueOf(line.charAt(2));
        // arr[2] = Integer.valueOf(line.charAt(4));
        return arr;
    }

    public static String getPrettyIntArray(int[] A)
    {
        StringBuilder sb = new StringBuilder("[");
        int i;
        for (i = 0; i < A.length - 1; i++)
            sb.append(A[i] + ", ");
        sb.append(A[i]);
        sb.append("]");
        return sb.toString();
    }

    
    private int[][] createDataSet()
    {
        System.out.println("Enter t :");
        int t = sc.nextInt();
        int ret[][] = new int[t][3];
        for (int i = 0; i < t; i++)
        {
            ret[i] = getTrioInput();
        }
        return ret;
    }

    private char[] processOutput(int[][] data)
    {
        char ret[] = new char[data.length];
        for (int i = 0; i < ret.length; i++)
        {
            int subdata[] = data[i];
            int a = subdata[0];
            int b = subdata[1];
            int c = subdata[2];
            if (a + b == c)
            {
                ret[i] = '+';
                continue;
            }
            if (a - b == c)
            {
                ret[i] = '-';
                continue;
            }
            ret[i] = '*';
        }
        return ret;
    }

    public static void main(String[] args) {
        // int t = 5;

        Main m = new Main();
        // System.out.println(getPrettyIntArray(m.getTrioInput()));
        int[][] data = m.createDataSet();
        // m.processOutput(null)
        for (char c : m.processOutput(data)) {
            System.out.println(c);
        }
        
        sc.close(); 
    }
}
