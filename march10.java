class Solution {
    public int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] prev = new int[n + 1], curr = new int[n + 1];
        for (int i = 0; i <= n; i++) prev[i] = i;
        for (int i = 1; i <= m; i++) {
            curr[0] = i;
            for (int j = 1; j <= n; j++)
                curr[j] = s1.charAt(i-1) == s2.charAt(j-1) ? prev[j-1] : 1 + Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n];
    }
}
