class Solution {
    public static Node findFirstNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if ((slow = slow.next) == (fast = fast.next.next)) {
                for (slow = head; slow != fast; slow = slow.next, fast = fast.next);
                return slow;
            }
        }
        return null;
    }
}
