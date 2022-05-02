package adancedDSA.Graphs.questions;

import java.util.ArrayList;
import java.util.List;

public class CheckCycle {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {0,0,0,0,1},
                {1,0,0,1,0},
                {1,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0}
        };
        System.out.println(isCycle(matrix));
    }
    private static boolean isCycle(Integer[][] matrix){
        boolean[] visited = new boolean[matrix.length];
        boolean[] recursive = new boolean[matrix.length];

        for (int i = 0;i<matrix.length; i++){
            if(!visited[i] && isCyclicGraph(matrix,i, visited, recursive)){
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicGraph(Integer[][] matrix, int vertix, boolean[] visited, boolean[] recursive){


        if(recursive[vertix]){
            return true;
        }


        if(visited[vertix]){
            return false;
        }

        visited[vertix] = true;
        recursive[vertix] = true;

        List<Integer> reachableNodes = getReachableVertices(matrix, vertix);

        for(Integer reachableVertex: reachableNodes){
            if(isCyclicGraph(matrix, reachableVertex, visited, recursive )){
                return true;
            }
        }
        recursive[vertix] = false;
        return false;
    }

    private static ArrayList<Integer> getReachableVertices(Integer[][] matrix, Integer vertex){
        ArrayList<Integer> vertices = new ArrayList<>();
        for(int i =0;i< matrix.length ;i++){
            if(matrix[i][vertex] == 1){
                vertices.add(i);
            }
        }
        return vertices;
    }
}
