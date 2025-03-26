class Solution {
    public boolean wordBreak(String s, String[] d) {
        Set<String> set = new HashSet<>(Arrays.asList(d));
        int n = s.length(), m = 0;
        for (String w : d) m = Math.max(m, w.length());
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (int j = 1; j <= m && i + j <= n; j++)
                if (set.contains(s.substring(i, i + j))) dp[i + j] = true;
        }
        return dp[n];
    }
}
