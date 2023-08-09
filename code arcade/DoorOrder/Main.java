package DoorOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UtilsClass {
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
}

public class Main {
    private Scanner sc = new Scanner(System.in);

    private int[] getIndexArrayOfUniqueChar(String s, char c)
    {
        List<Integer> l = new ArrayList<>();
        int i = 0, j = 1;
        while (i < s.length())
        {
            if (s.charAt(i) == c)
                l.add(j++);
            i++;
        }
        int a[] = l.stream().mapToInt(ii -> ii).toArray();
        if (c == '$')
        {
            for (j = 0; j < a.length / 2; j++)
            {
                int temp = a[j];
                a[j] = a[a.length - 1 - j];
                a[a.length - 1 - j] = temp;
            }
        }
        return a;
    }

    public boolean isTrueOrder(String s)
    {
        int i = 0; // % idx
        int j = 0; // $ idx
        int k = 0;
        for (k = 0; k < s.length(); k++)
        {
            if (s.charAt(k) == '%')
                i = k;
        }
        for (k = 0; k < s.length(); k++)
        {
            if (s.charAt(k) == '$')
                j = k;
        }
        return i < j;
    }

    private int[] joinIntArray(int[] A, int[] B)
    {
        // int n = A.length + B.length;
        int ret[] = new int[A.length + B.length];
        // int k = 0;
        for (int k = 0; k < A.length + B.length; k++)
        {
            // dup A
            if (k < A.length)
                ret[k] = A[k];
            // dup B
            else
                ret[k] = B[k - B.length];
        }
        return ret;
    }

    private static void makeTask(String inputSequence)
    {
        Main M = new Main();
        // System.out.println(M.isTrueOrder(inputSequence));
        if (!M.isTrueOrder(inputSequence))
        {
            System.out.println("If you love somebody, let them go, for if they return, they were always yours. And if they don\u2019t, they never were.\u201D");
            return;
        }
        int[] openIndices = M.getIndexArrayOfUniqueChar(inputSequence, '%');
        int[] closeIndices = M.getIndexArrayOfUniqueChar(inputSequence, '$');
        // System.out.println(UtilsClass.getPrettyIntArray(openIndices));
        // System.out.println(UtilsClass.getPrettyIntArray(closeIndices));
        
        System.out.println(
            UtilsClass.getPrettyIntArray(M.joinIntArray(openIndices, closeIndices))
        );

    }

    public static void main(String[] args) {
        // String inputSequence = M.sc.nextLine();
        Scanner sc = new Scanner(System.in);;
        Main.makeTask(sc.nextLine());
        sc.close();

        // String inputSequence = "%$";
        // String inputSequence = "$%";
        // String inputSequence = "%%%$$$";
        


        // String A = "%$";
        // String B = "$%";
        // String C = "%%%$$$";

        // Main.makeTask(A);
        // Main.makeTask(B);
        // Main.makeTask(C);

    }
}
