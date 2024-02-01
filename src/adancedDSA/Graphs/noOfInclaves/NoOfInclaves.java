package adancedDSA.Graphs.noOfInclaves;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfInclaves {

    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0,}
                };
        int res = numberOfEnclaves(grid);
        System.out.println(res);
    }
    static int numberOfEnclaves(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        Queue<Pair> queue = new LinkedList<>();


        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){

                if(i == 0 || j == 0 || i  == row-1 || j == col-1){
                    if(grid[i][j] == 1){
                        queue.add(new Pair(i, j));
                        vis[i][j] = true;
                    }
                }
            }
        }


        solve(vis, grid, queue);

        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    static boolean check(int row, int col, int[][] grid, boolean[][] vis){
        return (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && !vis[row][col] && grid[row][col] == 1);
    }

    static void solve(boolean[][] vis, int[][] grid, Queue<Pair> queue) {
        int[] drow = {0, -1, 0, 1};
        int[] dcol = {-1, 0, 1, 0};

        while (!queue.isEmpty()) {
            int row = queue.peek().i;
            int col = queue.peek().j;

            queue.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = drow[i] + row;
                int newCol = dcol[i] + col;

                if (check(newRow, newCol, grid, vis)) {
                    queue.add(new Pair(newRow, newCol));
                    vis[newRow][newCol] = true;
                }
            }
        }
    }
}
