class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        int i = 0, j = n - 1, idx = A >= 0 ? n - 1 : 0;

        while (i <= j) {
            int val1 = quad(arr[i], A, B, C);
            int val2 = quad(arr[j], A, B, C);
            if (A >= 0) {
                res.set(idx--, val1 > val2 ? val1 : val2);
                if (val1 > val2) i++; else j--;
            } else {
                res.set(idx++, val1 < val2 ? val1 : val2);
                if (val1 < val2) i++; else j--;
            }
        }
        return res;
    }

    private int quad(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
}
