package knapsack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KnapsackSolver
{
    public KnapsackSolver()
    {

    }

    // public record Data(int value, int widght, float ratio) {
    // }

    /**
     * InnerKnapsackSolver
     */
    public class Data {
        public int value;
        public int weight;
        public float ratio;
        public boolean isSelected;

        public Data(int value, int weight, float ratio) {
            this.value = value;
            this.weight = weight;
            this.ratio = ratio;
        }
        
    }


    // public void solve(Collection<Integer> coll)
    public void solve(List<Integer> coll)
    {
        int M = 45;
        System.out.println(coll);    
        int[] weights = {8, 13, 12, 15, 20};
        List<Data> X = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            float ratio = (float)coll.get(i) /  (float)weights[i];
            Data dt = new Data(coll.get(i), weights[i], ratio);
            X.add(dt);
        }

        // System.out.println(X);
        // * desc sort
        Collections.sort(X, (a, b) -> {
            // return -a.ratio.compareTo(b.ratio);
            return (int)((-a.ratio + b.ratio) * 100);
        });

        // System.out.println(X);
        float sumValue = 0;
        for (int i = 0; i < 5; i++)
        {
            float r = X.get(i).ratio;
            int w = X.get(i).weight;
            int v = X.get(i).value;
            // System.out.println(r);
            if (w < M)
            {
                X.get(i).isSelected = true;
                sumValue += (v * 1);
                M -= w;
            }
            // System.out.println(M);
            // * 823131

            // System.out.println("selected ");
            // System.out.println(X.get(i).isSelected);
            var s = String.format("item %d, value = %d, selected = %s", 
                i, v, X.get(i).isSelected
            );
            System.out.println(s);
        }

        System.out.println("sum value = " + sumValue);


    }

    public static void main(String[] args) {
        var ks = new KnapsackSolver();
        // int[] A = {86, 51, 51, 98, 80};
        Integer[] A = {86, 51, 51, 98, 80};
        ks.solve(Arrays.asList(A));
    }
}