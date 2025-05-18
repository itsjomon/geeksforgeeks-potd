class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = false;

        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    Node node = deque.pollFirst();
                    level.add(node.data);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    Node node = deque.pollLast();
                    level.add(node.data);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }

            result.addAll(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
