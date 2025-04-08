class Solution {
    void dfs(List<List<Integer>> g, boolean[] vis, int u) {
        vis[u] = true;
        for (int v : g.get(u)) if (!vis[v]) dfs(g, vis, v);
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int[] e : edges)
            if (!(e[0] == c && e[1] == d || e[0] == d && e[1] == c)) {
                g.get(e[0]).add(e[1]);
                g.get(e[1]).add(e[0]);
            }
        boolean[] vis = new boolean[V];
        dfs(g, vis, c);
        return !vis[d];
    }
}
