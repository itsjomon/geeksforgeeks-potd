class Solution {
    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    private boolean checkDeadEnd(Node node, int min, int max) {
        if (node == null) return false;
        if (min == max) return true;
        return checkDeadEnd(node.left, min, node.data - 1) ||
               checkDeadEnd(node.right, node.data + 1, max);
    }
}
