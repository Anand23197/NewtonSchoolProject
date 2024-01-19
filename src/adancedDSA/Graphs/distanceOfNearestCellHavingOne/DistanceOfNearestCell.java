package adancedDSA.Graphs.distanceOfNearestCellHavingOne;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
   static class Pair{
        int i;
        int j;
        int c;

        Pair(int i ,int j, int c){
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        int[][] res = nearest(grid);
    }

    public static int[][] nearest(int[][] grid)
    {
        // Code here
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];
        int[][] res = new int[row][col];
        Queue<Pair> queue = new LinkedList<>();

        for(int i= 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    queue.add(new Pair(i,j, 0));
                    res[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }

        int[] drow = {0,-1,0,1};
        int[] dcol = {-1,0,1,0};
        while(!queue.isEmpty()){
            int ro = queue.peek().i;
            int co = queue.peek().j;
            int cnt = queue.peek().c;
            queue.remove();

            for(int i = 0;i<4;i++){

                int r = drow[i] + ro;
                int c = dcol[i] + co;
                if(isSafe(r, c, row, col, vis)){
                    res[r][c] = cnt+1;
                    vis[r][c] = true;
                    queue.add(new Pair(r, c, cnt+1));
                }

            }

        }
        return res;
    }

  static boolean isSafe(int r, int c, int row, int col, boolean[][] vis){
        return (r < row) && (c < col) && (c >=0) && (r >=0) && !vis[r][c];
    }
}
