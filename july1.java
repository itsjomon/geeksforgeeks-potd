class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;
        int[] freq = new int[26];
        int distinct = 0, count = 0;
        for (int i = 0; i < k; i++) {
            if (freq[s.charAt(i) - 'a']++ == 0) distinct++;
        }
        if (distinct == k - 1) count++;
        for (int i = k; i < s.length(); i++) {
            if (--freq[s.charAt(i - k) - 'a'] == 0) distinct--;
            if (freq[s.charAt(i) - 'a']++ == 0) distinct++;
            if (distinct == k - 1) count++;
        }
        return count;
    }
}
