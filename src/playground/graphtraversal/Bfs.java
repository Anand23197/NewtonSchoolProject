package playground.graphtraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        adj.add(l1);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(2);
        l2.add(4);
        adj.add(l2);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(5);
        l3.add(1);
        adj.add(l3);

        performBfs(adj);
    }
    static void performBfs(ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();





    }
}
