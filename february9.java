class Solution {
    int dfs(Node r, int[] res) {
        if (r == null) return 0;
        int l = Math.max(0, dfs(r.left, res)), rgt = Math.max(0, dfs(r.right, res));
        res[0] = Math.max(res[0], l + rgt + r.data);
        return Math.max(l, rgt) + r.data;
    }
    int findMaxSum(Node root) {
        int[] res = {Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }
}
