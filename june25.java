class Solution {
    public boolean sameFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int max = 0, min = Integer.MAX_VALUE, maxCount = 0, minCount = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (f > max) { max = f; maxCount = 1; }
            else if (f == max) maxCount++;
            if (f < min) { min = f; minCount = 1; }
            else if (f == min) minCount++;
        }

        return max == min ||
               (max - min == 1 && maxCount == 1) ||
               (min == 1 && minCount == 1 && max == min + 1);
    }
}
