package adancedDSA.Graphs.bfsUsingMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSUsingMatrix {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,1},
                {0,0,0,0,0}
        };
        performBFSUsingMatrix(matrix);
    }

    private static void performBFSUsingMatrix(Integer[][] matrix){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);

        boolean[] visited = new boolean[matrix.length];

        while(!queue.isEmpty()){
            Integer vertex = queue.remove();
            System.out.print(vertex + " ");
            visited[vertex] = true;
            ArrayList<Integer> vertices = getReachableVertices(matrix, vertex);
            for(Integer newVertex : vertices){
                if(!visited[newVertex]){
                    queue.add(newVertex);
                }
            }
        }
    }
    private static ArrayList<Integer> getReachableVertices(Integer[][] matrix, Integer vertex){
        ArrayList<Integer> vertices = new ArrayList<>();
        for(int i =0;i< matrix.length ;i++){
            if(matrix[vertex][i] == 1){
                vertices.add(i);
            }
        }
        return vertices;
    }
}

