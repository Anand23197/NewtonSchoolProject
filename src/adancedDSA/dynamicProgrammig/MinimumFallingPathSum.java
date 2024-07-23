package adancedDSA.dynamicProgrammig;

public class MinimumFallingPathSum {
        //memoization technique
    int solve(int i, int j, int[][] matrix, int[][] dp){
        if(j<0 || j >= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(i == 0 ){
            return matrix[i][j];
        }
        if(dp[i][j] != 0) return dp[i][j];

        int dl = solve(i-1, j-1, matrix, dp);
        int dn = solve(i-1, j, matrix, dp);
        int dr = solve(i-1, j+1,matrix , dp);

        return dp[i][j] = matrix[i][j] + Math.min(dl, Math.min(dn, dr));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
//        int[][] dp = new int[row][col];
        int min = Integer.MAX_VALUE;

        //Tabulation bottom up technique
//        for (int i = 0; i < matrix.length; i++) {
//            dp[0][i] = matrix[0][i];
//        }
//
//        for (int i = 1; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//
//                int dl = Integer.MAX_VALUE;
//                if (j - 1 >= 0) {
//                    dl = dp[i-1][j - 1];
//                }
//
//                int dn = dp[i-1][j];
//                int dr = Integer.MAX_VALUE;
//                if (j + 1 < matrix[0].length) {
//                    dr = dp[i-1][j + 1];
//                }
//                dp[i][j] = matrix[i][j] + Math.min(dl, Math.min(dn, dr));
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            min = Math.min(dp[row - 1][i], min);
//        }

        // dp with space optimization
        int[] prev = new int[row];

        for(int i = 0;i<matrix.length;i++){
            prev[i] = matrix[0][i];
        }

        for(int i = 1;i<row;i++){
            int[] cur = new int[col];
            for(int j = 0;j<col;j++){

                int dl = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    dl = prev[j-1];
                }

                int dn = prev[j];
                int dr = Integer.MAX_VALUE;
                if( j+1 < matrix[0].length){
                    dr = prev[j+1];
                }
                cur[j] = matrix[i][j] + Math.min(dl, Math.min(dn, dr));
            }
            prev = cur;
        }

        for(int i = 0;i<matrix.length;i++){
            min = Math.min(prev[i],min);
        }
        return min;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int ans = minFallingPathSum(matrix);
        System.out.println(ans);
    }
}
