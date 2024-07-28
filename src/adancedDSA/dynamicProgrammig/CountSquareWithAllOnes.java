package adancedDSA.dynamicProgrammig;

public class CountSquareWithAllOnes {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];


        for(int i = 0 ;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 0;i<m;i++){
            dp[i][0] = matrix[i][0];
        }


        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1])+1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        int sum = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                sum += dp[i][j];
            }
        }

        return sum;

    }
    public static void main(String[] args) {

        int[][] matrix = {{0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        int ans = countSquares(matrix);
        System.out.println(ans);
    }
}
