class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        return 0; // No loop found
    }

    // Step 2: Count nodes in loop
    private int countLoopLength(Node node) {
        int count = 1;
        Node temp = node;
        while (temp.next != node) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
