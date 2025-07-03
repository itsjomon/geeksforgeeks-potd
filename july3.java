class Solution {
    public int longestKSubstr(String s, int k) {
        int max = -1, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) map.remove(ch);
                left++;
            }
            if (map.size() == k) max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
