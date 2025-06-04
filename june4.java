public class Solution {
    public int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        int[][] prev = new int[n2 + 1][n3 + 1];
        int[][] curr = new int[n2 + 1][n3 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) &&
                        s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        curr[j][k] = 1 + prev[j - 1][k - 1];
                    } else {
                        curr[j][k] = Math.max(prev[j][k],
                                              Math.max(curr[j - 1][k], curr[j][k - 1]));
                    }
                }
            }

            for (int j = 0; j <= n2; j++) {
                System.arraycopy(curr[j], 0, prev[j], 0, n3 + 1);
            }
        }
        return curr[n2][n3];
    }
}
