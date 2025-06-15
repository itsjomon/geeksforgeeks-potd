class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1, right = 0;
        for (int num : arr) right = Math.max(right, num);
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2, sum = 0;
            for (int num : arr) sum += (num + mid - 1) / mid;
            if (sum <= k) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
