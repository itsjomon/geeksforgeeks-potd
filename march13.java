class Solution {
    static int knapsack(int W, int[] val, int[] wt) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) 
            for (int j = W; j >= wt[i]; j--) 
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
        return dp[W];
    }
}
