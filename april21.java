class Solution {
    int missingNum(int[] a) {
        int x = 0;
        for (int i = 0; i < a.length; ++i) x ^= a[i] ^ (i + 1);
        return x ^ (a.length + 1);
    }
}
