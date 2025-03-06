class Solution {
    Node first, middle, last, prev;

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    void correctBST(Node root) {
        first = middle = last = prev = null;
        inorder(root);
        int temp = first.data;
        first.data = (last != null) ? last.data : middle.data;
        if (last != null) last.data = temp;
        else middle.data = temp;
    }
}
