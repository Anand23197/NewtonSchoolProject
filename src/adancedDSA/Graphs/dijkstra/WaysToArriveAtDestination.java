package adancedDSA.Graphs.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class PairDestination{
    int node;
    int dist;
    PairDestination(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
public class WaysToArriveAtDestination {
    public static void main(String[] args) {
       int n=7, m=10;
       int[][] edges= {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        int res = countPaths(n, edges, m);
        System.out.println(res);
    }

    static int countPaths(int n, int[][] roads, int m) {
        ArrayList<ArrayList<PairDestination>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            adj.get(roads[i][0]).add(new PairDestination(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new PairDestination(roads[i][0], roads[i][2]));
        }


        //defining a priorityQueue min heap
        PriorityQueue<PairDestination> pq = new PriorityQueue<>((a, b)-> a.dist - b.dist);

        int[] dist = new int[n];
        int[] ways = new int[n];

        for(int i = 0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new PairDestination(0,0));

        int mod = (int)(1e9+7);

        while(!pq.isEmpty()){
            int nodedist = pq.peek().dist;
            int node = pq.peek().node;

            pq.remove();

            for(PairDestination it : adj.get(node)){
                int adjNode = it.node;
                int adjdist = it.dist;

                //means first time we are getting
                if(adjdist + nodedist < dist[adjNode]){
                    dist[adjNode] = nodedist + adjdist;
                    pq.add(new PairDestination(adjNode,   dist[adjNode]));
                    ways[adjNode] = ways[node];
                }else if(adjdist + nodedist == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node])% mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
 }
