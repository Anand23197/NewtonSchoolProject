package adancedDSA.Graphs.dfsUsingRecursion;


import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                dfs(vis, stack, i, adj);
            }
        }

        ArrayList<ArrayList<Integer>> adjt = new ArrayList<>();

        for(int i = 0;i<V;i++){
            adjt.add(new ArrayList<>());
        }

        for(int i = 0;i<V;i++){
            vis[i] = 0;
            for(Integer it : adj.get(i)){
                //reverse it connection
                adjt.get(it).add(i);
            }
        }

        int scc = 0;

        while(!stack.isEmpty()){
            int node = stack.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node, vis, adjt);
            }
        }
        return scc;
    }

    static void dfs3(int node,int[] vis,ArrayList<ArrayList<Integer>> adjt){
        vis[node] = 1;
        for(Integer adNode : adjt.get(node)){
            if(vis[adNode] == 0){
                dfs3(adNode,vis, adjt);
            }
        }

    }
    static void dfs(int[] vis, Stack<Integer> st, int node, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;

        for(Integer adNode : adj.get(node)){
            if(vis[adNode] == 0){
                dfs(vis, st,adNode, adj);
            }
        }

        st.push(node);
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

       int res = kosaraju( n, adj);

        System.out.println(res);
    }
}
