class Solution {
    static Node segregate(Node head) {
        int[] count = new int[3];
        for (Node curr = head; curr != null; curr = curr.next) count[curr.data]++;
        Node curr = head;
        for (int i = 0; i < 3; i++)
            while (count[i]-- > 0) { curr.data = i; curr = curr.next; }
        return head;
    }
}
