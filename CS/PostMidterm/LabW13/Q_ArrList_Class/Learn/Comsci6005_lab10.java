package CS.PostMidterm.LabW13.Q_ArrList_Class.Learn;
import java.util.Arrays;
public class Comsci6005_lab10
{
    public static void main(String[] args)
    {
        // int[] arr = {2,4,6,15,7,10,13,18,3,20,21,23,1,5,8,22};
        // mergeRun(arr, 2, 2);
        int[] arr = {2,4,6,15,7,10,13,18,3,20,21,23,1,5,8,22,32,34,36,315,37,310,313,318,33,320,321,323,31,35,38,322};
        mergeRun(arr, 3, 2);
        //System.out.println(Arrays.toString(arr));
    }
    static void mergeRun(int [] x, int p, int q)
    {
        int [] ab = new int[x.length];
        while(p!=0)
        {
            for(int a=0;a<(int)Math.pow(2, p)/2;a++)
            {
                int mutiply = a*(int)Math.pow(2, q)*2;
                int firstSetLenght = mutiply+(int)(Math.pow(2,q));//4,
                int lastSetLenght =  mutiply+(int)(Math.pow(2,q))*2;//8

                int [] left = Arrays.copyOfRange(x, 0+(a*(int)(Math.pow(2,q))*2), firstSetLenght); //left is a
                //left = copy(ab,0,m-1,left);//make new array to store value
                int [] right = Arrays.copyOfRange(x, firstSetLenght, lastSetLenght); //right is b

                // copy(ab,m,m+n-1,right);
                int i = 0, j = 0, k = 0;
                while (i < left.length && j < right.length)
                {
                    // System.out.println("k = " + k );
                    // System.out.println("Left array = " + Arrays.toString(left));
                    // System.out.println("Right array = " + Arrays.toString(right));
                    // System.out.println("arr " + Arrays.toString(ab));

                    if (left[i] <= right[j])
                    {
                        ab[mutiply+k++] = left[i++];
                    }
                    else
                    {
                        ab[mutiply+k++] = right[j++];
                    }
                }
                while (i < left.length)
                { //Either copy tail of left
                    ab[mutiply+k++] = left[i++];
                }
                while (j < right.length)
                { //or copy tail of left
                ab[mutiply+k++] = right[j++];
                }
                // System.out.println("arr " + Arrays.toString(left));
                // System.out.println("arr " + Arrays.toString(right));
            }
            x=ab;
            p-=1;
            q+=1;
        }
        System.out.println("arr " + Arrays.toString(ab));
    }
}

