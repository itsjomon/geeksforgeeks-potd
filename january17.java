class Solution {
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length, product = 1, zeroCount = 0;
        for (int x : arr) if (x == 0) zeroCount++; else product *= x;
        if (zeroCount > 1) return new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = zeroCount > 0 ? (arr[i] == 0 ? product : 0) : product / arr[i];
        return arr;
    }
}
