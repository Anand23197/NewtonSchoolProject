package adancedDSA.Graphs.DetectCycleInUndirectedGraphBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUsingBfs {
   static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
          this.node = node;
          this.parent = parent;
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> zero = new ArrayList<>();
        zero.add(1);
        zero.add(2);
        adj.add(zero);

        ArrayList<Integer> one = new ArrayList<>();
        one.add(0);
        one.add(4);
        adj.add(one);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(0);
        two.add(3);
        two.add(5);
        adj.add(two);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(2);
        adj.add(three);

        ArrayList<Integer> four = new ArrayList<>();
        one.add(0);
        one.add(6);
        adj.add(four);

        ArrayList<Integer> five = new ArrayList<>();
        one.add(2);
        one.add(6);
        adj.add(five);

        ArrayList<Integer> six = new ArrayList<>();
        one.add(4);
        one.add(5);
        adj.add(six);

        int v = 7;
       boolean res = solve(adj, v);
        System.out.println(res);
    }
    static boolean solve(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] vis = new boolean[v];

        for(int i = 0;i<v;i++){
         if(!vis[i]){
             if(bfs(adj, vis, i)){
                 return true;
             }
         }
        }

        return false;
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i){
        Queue<Pair> queue = new LinkedList<>();
        vis[i] = true;

        queue.add(new Pair(i, -1));

        while(!queue.isEmpty()){
             int node = queue.peek().node;
             int parent = queue.peek().parent;
             queue.remove();
             for(int n : adj.get(node)){
                 if(!vis[n]){
                     queue.add(new Pair(n, node));
                     vis[n] = true;
                 }else{
                     if(n != parent) return true;
                 }
             }
        }
        return false;
    }
}
