class Solution {
    public int maxWater(int[] arr) {
        int l = 0, r = arr.length - 1, res = 0;
        while (l < r) res = Math.max(res, (r - l) * (arr[l] < arr[r] ? arr[l++] : arr[r--]));
        return res;
    }
}
