package adancedDSA.Graphs.bellmenFord;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    static int[] bellman_ford(int V,ArrayList<ArrayList<Integer>> edges,int S){
        int[] dist = new int[V];

        for(int i = 0;i<V;i++){
            dist[i] = (int)1e8;
        }
        dist[S] = 0;

        for(int i = 0;i<V-1;i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);

                if(dist[u] != 1e8 && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
             }
        }

        //nth relaxation to check negative cycle

        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);
            if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;

        ArrayList<ArrayList <Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };

       int[] res = bellman_ford(V, edges, S);

       for(int i = 0;i<V;i++){
           System.out.print(res[i] + " ");
       }
    }
}