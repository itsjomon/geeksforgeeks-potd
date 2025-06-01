class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int r1 = 0, c1 = 0;
        int r2 = mat2.length - 1, c2 = mat2[0].length - 1;
        int count = 0;

        while (r1 < mat1.length && r2 >= 0) {
            int val = mat1[r1][c1] + mat2[r2][c2];

            if (val == x) {
                count++;
                c1++;
                c2--;
            } else if (val < x) {
                c1++;
            } else {
                c2--;
            }
            if (c1 == mat1[0].length) {
                c1 = 0;
                r1++;
            }
            if (c2 == -1) {
                c2 = mat2[0].length - 1;
                r2--;
            }
        }

        return count;
    }
}
