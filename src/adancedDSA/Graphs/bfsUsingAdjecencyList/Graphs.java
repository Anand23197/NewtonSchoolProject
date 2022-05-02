package adancedDSA.Graphs.bfsUsingAdjecencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = getAdjList();
        //perform BFS using adjecency list
       performBFS(adjList);

    }
    //graph using Adjecency List
    private static ArrayList getAdjList(){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        adjList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        adjList.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        adjList.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        adjList.add(list4);

        ArrayList<Integer> list5 = new ArrayList<>();
        adjList.add(list5);

        return adjList;
    }

    static void performBFS(ArrayList<ArrayList<Integer>> adjList){
        Queue<Integer> queue = new LinkedList<>();

        //entering the graph using nodes
        queue.add(4);

        boolean[] visited = new boolean[adjList.size()];

        while(!queue.isEmpty()){
            Integer vertex = queue.remove();
            System.out.print(vertex + " ");
            visited[vertex] = true;
            ArrayList<Integer> newVertexReachable = adjList.get(vertex);
            if(!newVertexReachable.isEmpty()){
                for(Integer newVertex : newVertexReachable ){
                    if(!visited[newVertex]){
                        queue.add(newVertex);
                    }
                }
            }
        }
    }
}
