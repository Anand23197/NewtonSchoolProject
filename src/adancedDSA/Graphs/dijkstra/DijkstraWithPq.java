package adancedDSA.Graphs.dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

 class Pair{
    int w;
    int n;
    Pair(int w, int n){
        this.w = w;
        this.n = n;
    }
}

public class DijkstraWithPq {
    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.

        int[] res= dijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));

        pq.add(new Pair(0, S));

        int[] res = new int[V];

        for(int i = 0;i<V;i++){
            res[i] = (int)(1e9);
        }
        res[S] = 0;

        while(!pq.isEmpty()){
            int w = pq.peek().w;
            int n = pq.peek().n;

            pq.remove();

            for(ArrayList<Integer> newAdj : adj.get(n)){
                int adjw = newAdj.get(1);
                int adjn = newAdj.get(0);

                if(w + adjw < res[adjn]){
                    res[adjn] = w+ adjw;
                    pq.add(new Pair(res[adjn], adjn));
                }
            }

        }

        return res;

    }
}
