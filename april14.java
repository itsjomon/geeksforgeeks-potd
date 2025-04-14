class Solution {
    public String findOrder(String[] w) {
        List<List<Integer>> g = new ArrayList<>();
        int[] in = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < 26; i++) g.add(new ArrayList<>());
        for (String s : w) for (char c : s.toCharArray()) seen[c - 'a'] = true;
        for (int i = 0; i < w.length - 1; i++) {
            String a = w[i], b = w[i + 1];
            int j = 0, n = Math.min(a.length(), b.length());
            while (j < n && a.charAt(j) == b.charAt(j)) j++;
            if (j == n && a.length() > b.length()) return "";
            if (j < n) {
                g.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
                in[b.charAt(j) - 'a']++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) if (seen[i] && in[i] == 0) q.add(i);
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.append((char)(u + 'a'));
            for (int v : g.get(u)) if (--in[v] == 0) q.add(v);
        }
        for (int i = 0; i < 26; i++) if (seen[i] && in[i] > 0) return "";
        return res.toString();
    }
}
