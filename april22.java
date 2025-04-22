class Solution {
    public int findUnique(int[] arr) {
        int r = 0;
        for (int x : arr) r ^= x;
        return r;
    }
}
