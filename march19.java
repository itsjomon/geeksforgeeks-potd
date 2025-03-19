class Solution {
    public static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        if (2 * k >= n) {
            int profit = 0;
            for (int i = 1; i < n; i++)
                profit += Math.max(0, prices[i] - prices[i - 1]);
            return profit;
        }
        int[] dp = new int[2 * k + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int price : prices)
            for (int j = 1; j <= 2 * k; j++)
                dp[j] = (j % 2 == 1) ? Math.max(dp[j], dp[j - 1] - price) : Math.max(dp[j], dp[j - 1] + price);
        return dp[2 * k];
    }
}
