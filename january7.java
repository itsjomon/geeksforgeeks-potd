class Solution {
    int countPairs(int[] arr, int target) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int res = 0;

        for (int num : arr) {
            res += freq.getOrDefault(target - num, 0);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return res;
    }
}
