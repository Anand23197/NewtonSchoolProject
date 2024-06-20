package adancedDSA.dynamicProgrammig;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid , int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid,m-1, n-1 ,dp);
    }

     static int solve(int[][] grid, int m, int n, int[][] dp){

        if(m == 0 && n == 0) return grid[m][n];
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if(dp[m][n] != 0) return dp[m][n];

        return dp[m][n] = grid[m][n] + Math.min(solve(grid, m, n-1, dp),  solve(grid, m-1, n, dp) );
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] dp = new int[3][3];
        int res = minPathSum(grid, dp);
        System.out.println(res);
    }
}
