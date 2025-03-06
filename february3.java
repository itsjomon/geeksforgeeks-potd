class Solution {
    int height(Node node){
        return node == null ? -1 : 1 + Math.max(height(node.left), height(node.right));
    }
}
