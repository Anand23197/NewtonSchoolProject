package adancedDSA.Graphs.hamiltonionCycle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      // 1,2   2,3  3,4  2,4

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> adj1 = new ArrayList<>();
        adj1.add(1);
        adj1.add(2);
        adj.add(adj1);

        ArrayList<Integer> adj2 = new ArrayList<>();
        adj2.add(2);
        adj2.add(3);
        adj.add(adj2);

//        ArrayList<Integer> adj3 = new ArrayList<>();
//        adj3.add(3);
//        adj3.add(4);
//        adj.add(adj3);

        ArrayList<Integer> adj4 = new ArrayList<>();
        adj4.add(2);
        adj4.add(4);
        adj.add(adj4);

        //N = number of vertices, M = number of edges
        int n = 4;

        boolean test = check(n, adj);
        System.out.println(test);

    }

   static boolean check(int N, ArrayList<ArrayList<Integer>> Edges)
    {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=N;i++){
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> i : Edges){
            adj.get(i.get(0)).add(i.get(1));
            adj.get(i.get(1)).add(i.get(0));
        }

        boolean[] vis = new boolean[N+1];

        for(int i = 1;i<=N;i++){
            if(dfs(i, vis, 1, N, adj)){
                return true;
            }
            vis[i] = false;
        }
        return false;


    }

    static boolean dfs(int v, boolean[] vis, int count, int N, ArrayList<ArrayList<Integer>> adj){
        vis[v] = true;

        if(count == N) return true;

        for(int i = 0 ; i < adj.get(v).size();i++){
            if(!vis[adj.get(v).get(i)]){
                if(dfs(adj.get(v).get(i), vis, count+1, N, adj)){
                    return true;
                }
                vis[adj.get(v).get(i)] = false;
            }
        }
        return false;
    }

}
