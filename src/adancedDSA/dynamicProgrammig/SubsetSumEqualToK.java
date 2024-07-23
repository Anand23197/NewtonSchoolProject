package adancedDSA.dynamicProgrammig;

public class SubsetSumEqualToK {
    public static boolean subsetSumToK(int n, int k, int arr[], boolean[][] dp){
        // Write your code here.

        return solve(n-1, k, arr, dp);
    }

    static boolean solve(int n, int k, int[] arr,boolean[][] dp){
        if(k == 0){
            return true;
        }
        if(n == 0){
            return (arr[n] == k);
        }

        if(dp[n][k] == true){
            return dp[n][k] ;
        }

        boolean notTaken = solve(n-1,k, arr, dp);
        boolean taken = false;
        if(arr[n] <= k){
            taken = solve(n-1, k - arr[n], arr,dp);
        }

        return dp[n][k] = taken || notTaken;

    }
    public static void main(String[] args) {
        int arr[] = { 6, 1, 2, 1 };
        int k = 4;
        int n = arr.length;
        boolean[][]dp = new boolean[n][k+1];
//        System.out.println(subsetSumToK(n, k, arr, dp));

//        boolean dp[][] = new boolean[n][k + 1];

        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        System.out.println(dp[n - 1][k]);
    }
}
