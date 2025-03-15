class Solution {
    public int minCoins(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int c : coins)
            for (int j = c; j <= sum; j++)
                if (dp[j - c] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
