package adancedDSA.Graphs.eventualSafeNode;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {

   static boolean dfs(boolean[] vis, int[] pathVis,List<List<Integer>> adj, int node, int[] check){
        vis[node] = true;
        pathVis[node] = 1;
        check[node] = 0;
        for(int adNode : adj.get(node)){
            if(!vis[adNode]){
                if(dfs(vis, pathVis, adj, adNode, check)){
                    return true;
                }
            }else if(pathVis[adNode]==1){
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
   static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs(vis, pathVis, adj, i, check);
            }
        }

        for(int i = 0;i<V;i++){
            if(check[i] == 1){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int V = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(3).add(0);
        adj.get(4).add(5);
        adj.get(2).add(5);

        List<Integer> safeNodes = eventualSafeNodes(V, adj);
        for (int node : safeNodes) {
            System.out.print(node + " ");
        }

    }
}
