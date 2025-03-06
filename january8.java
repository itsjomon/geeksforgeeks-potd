class Solution {
    static int countTriangles(int[] arr) {
        Arrays.sort(arr);
        int count = 0, n = arr.length;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) count += (r-- - l);
                else ++l;
            }
        }
        return count;
    }
}
