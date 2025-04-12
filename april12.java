class Solution {
    public int[][] floodFill(int[][] A, int sr, int sc, int nc) {
        int m = A.length, n = A[0].length, oc = A[sr][sc];
        if (oc == nc) return A;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        A[sr][sc] = nc;
        int[] d = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p[0] + d[i], y = p[1] + d[i+1];
                if (x >= 0 && y >= 0 && x < m && y < n && A[x][y] == oc) {
                    A[x][y] = nc;
                    q.add(new int[]{x, y});
                }
            }
        }
        return A;
    }
}
