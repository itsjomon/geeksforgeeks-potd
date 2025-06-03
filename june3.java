class Solution {
    int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        int n = s.length(), left = 0, res = 0;
        int[] freq = new int[26];
        int distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[s.charAt(right) - 'a']++ == 0) distinct++;

            while (distinct > k) {
                if (--freq[s.charAt(left) - 'a'] == 0) distinct--;
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }
}
