package Mst;

import java.util.Arrays;

public class PrimRun
{
    public static void main(String[] args) 
    {
        // int[][] graph =  new int[5][5];
        int[][] graph =  {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        Prim prim = new Prim(graph);

        System.out.println("-input--");
        for (int[] row : prim.graph)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----");
        Prim.showTreeAdjacency(prim.getMst());
        System.out.println("------");
        Prim.showTreeAdjacency(prim.getMst(2));
    }
}