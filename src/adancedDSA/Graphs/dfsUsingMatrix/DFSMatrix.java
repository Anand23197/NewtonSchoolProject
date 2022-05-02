package adancedDSA.Graphs.dfsUsingMatrix;

import java.util.ArrayList;
import java.util.Stack;

public class DFSMatrix {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,1},
                {0,0,0,0,0}
                             };
        performDFS(matrix);
    }
    private static void performDFS(Integer[][] matrix){
        boolean[] visited = new boolean[matrix.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        visited[0] = true;

        while(!stack.isEmpty()){
            Integer vertex = stack.pop();

            System.out.print(vertex + " ");

            ArrayList<Integer> vertices = getReachableVertices(matrix, vertex);

            for(Integer newVertex : vertices){
                if(!visited[newVertex]){
                    stack.push(newVertex);
                    visited[newVertex] = true;
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
