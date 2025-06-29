class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (canSplit(arr, k, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private boolean canSplit(int[] arr, int k, int maxSum) {
        int count = 1, sum = 0;
        for (int num : arr) {
            if (sum + num > maxSum) {
                count++;
                sum = num;
                if (count > k) return false;
            } else {
                sum += num;
            }
        }
        return true;
    }
}
