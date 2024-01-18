package adancedDSA.Graphs.rottenOranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static  class Pair{
        int i;
        int j;
        int c;
        Pair(int i, int j, int c){
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int count = solve(grid, vis, row, col);
        System.out.println(count);
    }
    static int solve(int[][] grid, boolean[][] vis, int r, int c){
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;

        //add all rotten oranges in queue and count all the fresh oranges
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                }else if(grid[i][j] == 1){
                    freshOranges += 1;
                }
            }
        }


        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};

        int cnt = 0;
        while(!queue.isEmpty()){
            int i = queue.peek().i;
            int j = queue.peek().j;
            int count = queue.peek().c;
            queue.remove();
            cnt = count;
            for(int k = 0;k<4;k++){
                int row = i+drow[k];
                int col = j+dcol[k];
                if(!checkBoundry(r, c, row, col, vis, grid)){
                    grid[row][col] = 2;
                    queue.add(new Pair(row, col, cnt+1));
                    vis[row][col] = true;
                    freshOranges -= 1;
                }

            }
        }


        if(freshOranges == 0){
            return cnt;
        }

        return -1;

    }

   static boolean checkBoundry(int row, int col, int drow, int dcol,boolean[][] vis, int[][] grid){
        return (drow < 0 || drow >= row || dcol < 0 || dcol >= col || grid[drow][dcol] != 1 || vis[drow][dcol]) ;
    }
}
