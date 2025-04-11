class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<int[]>[] g = new List[V];
        for (int i = 0; i < V; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) g[e[0]].add(new int[]{e[1], e[2]});
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, src});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] > d[p[1]]) continue;
            for (int[] x : g[p[1]])
                if (p[0] + x[1] < d[x[0]])
                    q.offer(new int[]{d[x[0]] = p[0] + x[1], x[0]});
        }
        return d;
    }
}
