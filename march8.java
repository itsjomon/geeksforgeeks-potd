class Solution {
    static String longestPalindrome(String s) {
        int n = s.length(), start = 0, maxLen = 0;
        for (int i = 0; i < n; i++)
            for (int l : new int[]{i, i + 1}) {
                int j = i;
                while (j >= 0 && l < n && s.charAt(j) == s.charAt(l)) {
                    j--;
                    l++;
                }
                if (l - j - 1 > maxLen) {
                    start = j + 1;
                    maxLen = l - j - 1;
                }
            }
        return s.substring(start, start + maxLen);
    }
}
