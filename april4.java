class Solution {
    public boolean isCycle(int V, int[][] edges) {
        int[] p = new int[V];
        Arrays.fill(p, -1);
        for (int[] e : edges) {
            int a = f(p, e[0]), b = f(p, e[1]);
            if (a == b) return true;
            if (p[a] > p[b]) { int t = a; a = b; b = t; }
            p[a] += p[b]; p[b] = a;
        }
        return false;
    }
    int f(int[] p, int x) {
        return p[x] < 0 ? x : (p[x] = f(p, p[x]));
    }
}
