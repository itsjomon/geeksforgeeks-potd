class Solution {
    public int countWays(String s) {
        if (s.charAt(0) == '0') return 0;
        int prev2 = 1, prev1 = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = (s.charAt(i) != '0') ? prev1 : 0;
            if (s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) 
                curr += prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
