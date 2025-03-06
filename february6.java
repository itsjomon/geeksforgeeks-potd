class Solution {
    public static Node buildTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) m.put(inorder[i], i);
        int[] idx = new int[1];
        return build(0, inorder.length - 1, preorder, m, idx);
    }
    static Node build(int l, int r, int[] pre, HashMap<Integer, Integer> m, int[] idx) {
        if(l > r) return null;
        Node root = new Node(pre[idx[0]++]);
        root.left = build(l, m.get(root.data) - 1, pre, m, idx);
        root.right = build(m.get(root.data) + 1, r, pre, m, idx);
        return root;
    }
}
