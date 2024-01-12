package adancedDSA.Graphs.detectCycleInDirectedGraph;

import java.util.ArrayList;

// Detect cycle using dfs
class Graph{
    static int V;
    static ArrayList<ArrayList<Integer>> adj ;
    Graph(int v){
        V = v;
        adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
          adj.add(new ArrayList<>());
        }
    }

     void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    static boolean isCycleUtil(int i, boolean[] vis,boolean[] recStack){

        if(recStack[i]){
            return true;
        }

        if(vis[i]){
            return false;
        }
        vis[i] = true;
        recStack[i] = true;

        ArrayList<Integer> children = adj.get(i);

        for(int node : children){
            if(isCycleUtil(node, vis, recStack)){
                return true;
            }
        }

        recStack[i] = false;

        return false;
    }


     boolean isCyclic(){
        //mark all the vertices as not visited
        //and not part of recursive stack

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        //call the recursive helper function to detect cycle in differect dfs tree

        for(int i = 0;i < V;i++){
            if(isCycleUtil(i, visited, recStack)){
                return true;
            }
        }

        return false;

    }

}
public class DetectCycle {
    public static void main(String[] args) {
         Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
//        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
//        graph.addEdge(3, 3);

        if(graph.isCyclic()){
            System.out.println("graph has cycle");
        }else{
            System.out.println("cycle not present");
        }
    }
}
