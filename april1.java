class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> r = new ArrayList<>();
        boolean[] v = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) if (!v[i]) go(i, adj, v, r);
        return r;
    }
    void go(int i, ArrayList<ArrayList<Integer>> a, boolean[] v, ArrayList<Integer> r) {
        v[i] = true;
        r.add(i);
        for (int j : a.get(i)) if (!v[j]) go(j, a, v, r);
    }
}
