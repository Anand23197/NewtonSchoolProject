package adancedDSA.Graphs.binaryMaze;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int r;
    int c;
    int d;
    Pair(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
public class ShortestPathInBinaryMaze {

    static boolean checkSafe(int newRow, int newCol, int row , int col, int[][] grid, int dist, int[][] path){
        return (newRow >= 0 && newRow < row && newCol >= 0 &&
                newCol < col && grid[newRow][newCol] == 1 && dist + 1 < path[newRow][newCol]);
    }
    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;

        int row = grid.length;
        int col = grid[0].length;

        int[][] path = new int[row][col];

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                path[i][j] = (int)1e9;
            }
        }

        path[source[0]][source[1]] = 0;
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(source[0], source[1], 0));



        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};

        while(!queue.isEmpty()){
            int r = queue.peek().r;
            int c = queue.peek().c;
            int d = queue.peek().d;

            queue.remove();

            for(int i = 0;i<4;i++){
                int newRow = r + drow[i];
                int newCol = c + dcol[i];
                if(checkSafe(newRow, newCol, row, col, grid, d, path)){
                    path[newRow][newCol] = d+1;

                    if(newRow == destination[0] && newCol == destination[1]){
                        return d + 1;
                    }
                    queue.add(new Pair( newRow, newCol, d+1));
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};

        int[][] grid={{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};

       int res = shortestPath(grid, source, destination);
        System.out.println(res);
    }
}
