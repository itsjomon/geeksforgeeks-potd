class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++)
            for (int[] e : edges)
                if (dist[e[0]] < 1e8 && dist[e[0]] + e[2] < dist[e[1]])
                    dist[e[1]] = dist[e[0]] + e[2];
        for (int[] e : edges)
            if (dist[e[0]] < 1e8 && dist[e[0]] + e[2] < dist[e[1]])
                return new int[]{-1};
        return dist;
    }
}
