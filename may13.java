class Solution {
    public int nCr(int n, int r) {
        if (r > n) {
            return 0;
        }
        long sum = 1;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return (int)sum;
    }
}
