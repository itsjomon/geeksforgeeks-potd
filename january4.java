class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length, res = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        res += count * (count - 1) / 2;
                        break;
                    } else {
                        int cnt1 = 1, cnt2 = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            left++;
                            cnt1++;
                        }
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            right--;
                            cnt2++;
                        }
                        res += cnt1 * cnt2;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
