class Solution {
    public int longestUniqueSubstr(String s) {
        int[] lastSeen = new int[128];
        int maxLength = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            start = Math.max(start, lastSeen[s.charAt(end)]);
            lastSeen[s.charAt(end)] = end + 1;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
