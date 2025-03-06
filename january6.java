class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1, minDiff = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        while (l < r) {
            int sum = arr[l] + arr[r], diff = Math.abs(target - sum);
            if (diff < minDiff) {
                minDiff = diff;
                res = Arrays.asList(arr[l], arr[r]);
            }
            if (sum < target) l++;
            else r--;
        }
        return res;
    }
}
