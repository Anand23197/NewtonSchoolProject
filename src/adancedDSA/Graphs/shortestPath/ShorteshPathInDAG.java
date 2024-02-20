package adancedDSA.Graphs.shortestPath;


import java.util.ArrayList;
import java.util.Stack;

class Pair{
    int first, second;
    Pair(int f, int s) {
        first = f;
        second = s;
    }
}
class Solution{
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;

        for(int i = 0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;

            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }

        }
        st.push(node);
    }
    public int[] shortestPath(int n, int m , int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }

        int[] vis = new int[n];

        // perform topo sort using dfs and store result in stack

        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[n];
        for(int i = 0;i<n;i++){
            dist[i] = (int)(1e9);
        }

        dist[0] = 0;

        while(!st.isEmpty()){
            int node = st.pop();

            for(int i = 0;i < adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dist[node] + wt < dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }

        for(int i = 0;i<n;i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }

        return dist;

    }
}
public class ShorteshPathInDAG {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        Solution sl = new Solution();
        int[] res = sl.shortestPath(n, m, edge);

        for(int i = 0;i<n;i++){
            System.out.print(res[i] + " ");
        }
    }
}
