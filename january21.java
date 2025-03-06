class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node curr = head, newHead = null, tail = null;

        while (curr != null) {
            Node groupPrev = null, groupCurr = curr;
            int count = 0;

            while (curr != null && count < k) {
                Node next = curr.next;
                curr.next = groupPrev;
                groupPrev = curr;
                curr = next;
                count++;
            }

            if (newHead == null) newHead = groupPrev;
            if (tail != null) tail.next = groupPrev;
            tail = groupCurr;
        }

        return newHead;
    }
}
