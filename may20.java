class Solution {
    public static int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = getParents(root, parent, target);
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null && visited.add(node.left)) {
                    q.add(node.left); burned = true;
                }
                if (node.right != null && visited.add(node.right)) {
                    q.add(node.right); burned = true;
                }
                Node par = parent.get(node);
                if (par != null && visited.add(par)) {
                    q.add(par); burned = true;
                }
            }
            if (burned) time++;
        }
        return time;
    }

    private static Node getParents(Node root, Map<Node, Node> parent, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.data == target) targetNode = node;
            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
        return targetNode;
    }
}
