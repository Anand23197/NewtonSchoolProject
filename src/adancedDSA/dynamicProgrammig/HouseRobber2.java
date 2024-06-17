package adancedDSA.dynamicProgrammig;

public class HouseRobber2 {

   static int solve(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int nextPrev = 0;
        for(int i = 1;i<n;i++){
            int left = nums[i];
            // because it may go to negative index
            if(i > 1){
                left += nextPrev;
            }
            int right = 0 + prev;

            int cur = Math.max(left, right);
            nextPrev = prev;
            prev = cur;
        }
        return prev;
    }

    static int rob(int[] nums, int n){

        if(n == 1) return nums[0];
        int[] arr = new int[n-1];
        int[] arr2 = new int[n-1];


        for(int i = 1;i<n;i++){
            arr[i-1] = nums[i];
        }
        for(int i = 0;i<n-1;i++){
            arr2[i] = nums[i];
        }
        return Math.max(solve(arr), solve(arr2));
    }
    public static void main(String[] args) {
       int[] nums = {1,2,3,1};
        int n = nums.length;
        int res = rob(nums, n);
        System.out.println(res);
    }
}
