class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> r = new ArrayList<>();
        boolean[] v = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        v[0] = true;
        
        while (!q.isEmpty()) {
            int i = q.poll();
            r.add(i);
            for (int j : adj.get(i)) {
                if (!v[j]) {
                    v[j] = true;
                    q.add(j);
                }
            }
        }
        return r;
    }
}
