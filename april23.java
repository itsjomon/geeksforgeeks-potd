class Solution {
    public int[] singleNum(int[] arr) {
        int x = 0, a = 0, b = 0;
        for (int n : arr) x ^= n;
        for (int n : arr) if ((n & (x & -x)) != 0) a ^= n; else b ^= n;
        return a < b ? new int[]{a, b} : new int[]{b, a};
    }
}
