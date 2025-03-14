class Solution {
    public int count(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int j = coin; j <= sum; j++)
                dp[j] += dp[j - coin];
        return dp[sum];
    }
}
