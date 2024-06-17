package adancedDSA.dynamicProgrammig;

public class HouseRobber1 {

    public static int findMaxSum(int arr[], int n) {
        // Your code here
        // int[] dp = new int[n];
        // return solve(arr, n-1, dp);
        // dp[0] = arr[0];

        // for(int i = 1;i<n;i++){
        //  int left = arr[i];
        //because it may go to negative index
        //  if(i > 1){
        //      left += dp[i-2];
        //  }
        // int right = 0 + dp[i-1];

        // dp[i] = Math.max(left, right);
        // }
        // return dp[n-1];

        //with space optimization
        int prev = arr[0];
        int nextPrev = 0;
        for (int i = 1; i < n; i++) {
            int left = arr[i];
            // because it may go to negative index
            if (i > 1) {
                left += nextPrev;
            }
            int right = 0 + prev;

            int cur = Math.max(left, right);
            nextPrev = prev;
            prev = cur;
        }
        return prev;
    }

//     int solve(int[] arr, int n, int[] dp){
//
//         if(n == 0) return arr[n];
//
//         if(n < 0) return 0;
//
//         if(dp[n] != 0) return dp[n];
//
//         int left = arr[n] + solve(arr, n-2, dp);
//         int right = 0 + solve(arr, n-1, dp);
//
//         return dp[n] = Math.max(left, right);
//     }

    public static void main(String[] args) {
        int n = 5;
        int[] a = {6,5,5,7,4};
        int res = findMaxSum(a, n);
        System.out.println(res);
    }
}
