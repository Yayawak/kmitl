package Mst;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    int[][] graph;
    PriorityQueue<PrimEdge> pq;

    public Prim(int[][] graph)
    {
        this.graph = graph;
        // pq = new PriorityQueue<PrimEdge>(
        //     new Comparator<PrimEdge>() {

        //         @Override
        //         public int compare(PrimEdge o1, PrimEdge o2) {
        //             return 
        //         }
        // });
        // PriorityQueue
        // pq = new PriorityQueue<PrimEdge>(PrimEdge::getWeight);
        pq = new PriorityQueue<PrimEdge>((e1, e2) -> e1.weight - e2.weight);
    }

    public int[][] getMst()
    {
        return getMst(0);
    }

    public int[][] getMst(int source)
    {
        // System.out.printf("graph [h,w] = [%d,%d]\n ", graph.length, graph[0].length);
        // for (int i =0; i < graph.length; i++) 
        // {
        //     int u = graph[i][0];
        //     for (int j = i + 1; j < graph[i].length; j++)
        //     // for (int j = 0; j < graph[i].length; j++)
        //     {
        //         // if (i == j) continue;
        //         int w = graph[i][j];
        //         // * there are path from `u to v`
        //         // System.out.println(w);
        //         if (w != 0)
        //         {
        //             PrimEdge e = new PrimEdge(i, j, w);
        //             // pq.add(e);
        //             pq.offer(e);
        //         }
        //     }
        // }
        // while 
        // for (int i = source + 1; i < graph[source].length; i++)
        for (int i = 0; i < graph.length; i++)
        {
            if (graph[source][i] != 0)
            {
                var e = new PrimEdge(source, i, graph[source][i]);
                // System.out.println("added E to init pq : " + e);
                pq.offer(e);
            }
        }
        // pq.offer(null)

        // for (PrimEdge e : pq.)
        // while (!pq.isEmpty())
        // while (!pq.isEmpty())

        // while (!pq.isEmpty())
        // {
        //     PrimEdge e = pq.poll();
        //     System.out.println(e);
        // }

        Set<Integer> exploredVertices = new HashSet<>();
        exploredVertices.add(source);
        Set<PrimEdge> mst = new HashSet<>();
        // int[] 
        // if (pq.isEmpty())
        // {
        //     System.out.println("PQ EMPTY WTF ?");
        // }

        while(exploredVertices.size() != graph.length)
        {
            PrimEdge minDistEdge = pq.poll();
            // assert minDistEdge != null;
            // if (minDistEdge == null)
            // {
            //     System.out.println("EEEEEEEEEEEEEEEEEEEE");
            // }

            int u = minDistEdge.v;
            if (exploredVertices.contains(u))
            {
                continue;
            }
            // System.out.println("u retrived = " + u);

            for (int i = 0; i < graph[u].length; i++)
            // for (int i = u + 1; i < graph[u].length; i++)
            {
                if (graph[u][i] != 0)
                {
                // System.out.println(i);
                    // System.out.println("k");
                    pq.offer(new PrimEdge(u, i, graph[u][i]));
                }
            }
            // count++;
            // System.out.println(count);
            
            exploredVertices.add(u);
            // System.out.printf("size of exp = %d\n",exploredVertices.size());
            // System.out.println(exploredVertices);
            mst.add(minDistEdge);
            // System.out.println("current mst = " + mst);
        }

        // System.out.println(exploredVertices);
        // while (!pq.isEmpty())
        // {
        //     PrimEdge e = pq.poll();
        //     System.out.println(e);
        // }
        // System.out.println(mst);
        int[][] mstAdjMat = new int[graph.length][graph.length];
        // for (int i = 0; i < graph.length; i++)
        // {
        //     for (int j = 0; j < graph[0].length; j++)
        //     {
                
        //     }
        // }
        for (PrimEdge e : mst)
        {
            // for (int v : e.)
            mstAdjMat[e.u][e.v] = e.weight;
        }

        return mstAdjMat;
    }

    public static void showTreeAdjacency(int[][] adjs)
    {
        System.out.println("Minimum spanning tree is : ");
        for (int i = 0; i < adjs.length; i++)
        {
            System.out.println(Arrays.toString(adjs[i]));
        }
    }
}
