class Solution {
    public int findMaxSum(int[] arr) {
        int prev2 = 0, prev1 = 0;
        for (int num : arr) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
