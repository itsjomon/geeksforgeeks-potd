class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
