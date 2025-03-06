class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node dummy = new Node(0), tail = dummy;
        while (head1 != null && head2 != null) {
            tail.next = (head1.data <= head2.data) ? head1 : head2;
            if (head1.data <= head2.data) head1 = head1.next;
            else head2 = head2.next;
            tail = tail.next;
        }
        tail.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }
}
