class Solution {
    public boolean findTarget(Node root, int target) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int left = 0, right = inorder.size() - 1;
        while (left < right) {
            int sum = inorder.get(left) + inorder.get(right);
            if (sum == target) return true;
            if (sum < target) left++;
            else right--;
        }
        return false;
    }

    private void inorderTraversal(Node node, List<Integer> inorder) {
        if (node == null) return;
        inorderTraversal(node.left, inorder);
        inorder.add(node.data);
        inorderTraversal(node.right, inorder);
    }
}
