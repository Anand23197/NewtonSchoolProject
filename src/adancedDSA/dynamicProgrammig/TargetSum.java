package adancedDSA.dynamicProgrammig;

public class TargetSum {
    static int findWaysUtil(int ind, int target, int[] arr, int[][] dp){

        if(ind == 0){
            if(target == 0 && arr[ind] == 0){
                return 2;
            }
            if(target == 0 || arr[ind] == target){
                return 1;
            }
            return 0;
        }

        if(dp[ind][target] != 0) return dp[ind][target];

        int notTake = findWaysUtil(ind-1, target, arr, dp);
        int take = 0;
        if(arr[ind] <= target){
            take = findWaysUtil(ind-1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = take+notTake;
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        int totSum = (sum - target)/2;
        if(totSum < 0 || ((sum - target)%2 != 0)) return 0;
        int[][] dp = new int[n][totSum+1];
        return findWaysUtil(n-1, totSum, nums, dp);
    }
    public static void main(String[] args) {
        int[] arr = {2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        int target = 1000;
        int res = findTargetSumWays(arr, target);
        System.out.println(res);
    }
}
