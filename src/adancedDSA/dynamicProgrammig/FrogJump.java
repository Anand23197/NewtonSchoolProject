package adancedDSA.dynamicProgrammig;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        // int[] dp = new int[n];

        //1st solution memoization with bottom up approach
        // return solve(n-1, heights, dp);

        // 2nd solution with tabulation top-down approach
        //     for(int i = 1;i<n;i++){
        //          int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
        //    int right = Integer.MAX_VALUE;
        //    if(i > 1)
        //     right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);

        //     dp[i] = Math.min(left, right);
        //     }

        //     return dp[n-1];

        //3rd solution with space optimization
        int prev = 0;
        int secondPrev = 0;

        for(int i = 1;i<n;i++){
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = secondPrev + Math.abs(heights[i] - heights[i-2]);

            int cur = Math.min(left, right);
            secondPrev = prev;
            prev = cur;
        }
        return prev;
    }


    static int solve(int n, int[] heights, int[] dp){

        if(n <= 0){
            return 0;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int left = solve(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = solve(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);

        return dp[n] = Math.min(left, right);
    }
    public static void main(String[] args) {
        int n = 8;
        int[] heights = {7, 4, 4, 2, 6, 6, 3, 4};

        int res = frogJump(n, heights);
        System.out.println(res);
    }
}
