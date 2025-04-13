class Solution {
    Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        m.put(node, new Node(node.val));
        q.add(node);
        while (!q.isEmpty()) {
            for (Node n : q.peek().neighbors) {
                if (!m.containsKey(n)) {
                    m.put(n, new Node(n.val));
                    q.add(n);
                }
                m.get(q.peek()).neighbors.add(m.get(n));
            }
            q.poll();
        }
        return m.get(node);
    }
}
