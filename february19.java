class Solution {
    public Node mergeKLists(List<Node> lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.data));
        for (Node head : lists) if (head != null) pq.add(head);
        Node dummy = new Node(0), tail = dummy;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) pq.add(tail.next);
        }
        return dummy.next;
    }
}
