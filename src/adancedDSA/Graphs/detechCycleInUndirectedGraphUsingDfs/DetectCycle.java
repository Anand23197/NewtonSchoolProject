package adancedDSA.Graphs.detechCycleInUndirectedGraphUsingDfs;

import java.util.ArrayList;

public class DetectCycle {
    class Pair{
        int node ;
        int parent ;

        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        adj.add(first);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(0);
        second.add(2);
        second.add(4);
        adj.add(second);

        ArrayList<Integer> third = new ArrayList<>();
        third.add(1);
        third.add(3);
        adj.add(third);

        ArrayList<Integer> four = new ArrayList<>();
        four.add(2);
        four.add(4);
        adj.add(four);

        ArrayList<Integer> five = new ArrayList<>();
        five.add(1);
        five.add(3);
        adj.add(five);

        int v = 5;
        boolean[] vis = new boolean[v];
        boolean res = solve(adj, 0, v, vis);
    }

    static boolean solve(ArrayList<ArrayList<Integer>> adj, int stNode, int v, boolean[] vis){
        vis[stNode] = true;
        for(int n : adj.get(stNode)){
              if(!vis[n]){

              }
        }
        return false;
    }
}
