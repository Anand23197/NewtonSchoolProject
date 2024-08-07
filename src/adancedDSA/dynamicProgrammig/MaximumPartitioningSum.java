package adancedDSA.dynamicProgrammig;

public class MaximumPartitioningSum {
    static int f(int ind, int[] num, int k) {
        int n = num.length;
        // Base case:
        if (ind == n) return 0;

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        // Iterate through the next 'k' elements or remaining elements if less than 'k'.
        for (int j = ind; j < Math.min(ind + k, n); j++) {
            len++;
            maxi = Math.max(maxi, num[j]);
            int sum = len * maxi + f(j + 1, num, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
    static int maxSumAfterPartitioning(int[] num, int k) {
        return f(0, num, k);
    }
    public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int maxSum = maxSumAfterPartitioning(num, k);
        System.out.println("The maximum sum is: " + maxSum);
    }
}
