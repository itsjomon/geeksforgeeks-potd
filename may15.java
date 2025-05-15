class Solution {
    public int countSubstring(String s) {
        int[] cnt = new int[256];
        long ans = 0;
        for (char c : s.toCharArray()) cnt[c]++;
        for (int x : cnt) ans += (long)x * (x + 1) / 2;
        return (int)ans;
    }
}
