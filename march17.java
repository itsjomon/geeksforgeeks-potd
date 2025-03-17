class Solution {
    static boolean isSubsetSum(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : arr)
            for (int j = sum; j >= num; --j)
                dp[j] |= dp[j - num];
        return dp[sum];
    }
}
