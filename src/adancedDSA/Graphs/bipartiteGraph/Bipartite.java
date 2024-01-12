package adancedDSA.Graphs.bipartiteGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    boolean check(int s,  int v,int[] color, ArrayList<ArrayList<Integer>> adj){

        color[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int it : adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[it];
                    queue.add(it);
                }
                else if(color[it] == color[node]) return false;
            }
        }

        return true;

    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        for(int i = 0;i<V;i++){
            color[i] = -1;
        }

        for(int i = 0; i<V;i++){
            if(color[i] == -1){
                if(check(i, V,color,adj)){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Bipartite obj = new Bipartite();
        boolean ans = obj.isBipartite(4, adj);
        if(ans)
            System.out.println("YES");
        else System.out.println("NO");
    }

}
