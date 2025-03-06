class Solution {
    int countPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1, ans = 0;
        while (l < r) if (arr[l] + arr[r] < target) ans += (r - l++);
        else r--;
        return ans;
    }
}
