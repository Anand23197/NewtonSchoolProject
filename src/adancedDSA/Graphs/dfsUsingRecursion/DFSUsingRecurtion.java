package adancedDSA.Graphs.dfsUsingRecursion;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class DFSUsingRecurtion {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = getAdjList();

         performDFSUsingRecursion(adjList);
    }
    private static void performDFSUsingRecursion(ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited = new boolean[adjList.size()];
        performDFSUsingRecursion(adjList, 0, visited);
    }
    private static void performDFSUsingRecursion(ArrayList<ArrayList<Integer>> adjList, Integer currentVertex, boolean[] visited){
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true;

        ArrayList<Integer> reachableVertices = adjList.get(currentVertex);

        for(int i = reachableVertices.size()-1; i>=0; i--){
            Integer reachableVertex = reachableVertices.get(i);
            if(!visited[reachableVertex]){
                performDFSUsingRecursion(adjList,reachableVertex, visited);
            }
        }
    }

    //make graph using adjecency list
    private static ArrayList getAdjList(){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        adjList.add(list1);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        adjList.add(list2);

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        adjList.add(list3);

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(2);
        list4.add(4);
        adjList.add(list4);

        ArrayList<Integer> list5 = new ArrayList<Integer>();
        adjList.add(list5);

        return adjList;
    }
}
