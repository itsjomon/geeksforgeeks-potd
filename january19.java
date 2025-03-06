class Solution {
  public Node rotate(Node head, int k) {
    if (head == null || head.next == null || k == 0) return head;
    int len = 1;
    Node tail = head;
    while (tail.next != null) {
      tail = tail.next;
      len++;
    }
    k %= len;
    if (k == 0) return head;
    Node newTail = head;
    for (int i = 1; i < k; i++) {
      newTail = newTail.next;
    }
    Node newHead = newTail.next;
    newTail.next = null;
    tail.next = head;
    return newHead;
  }
}
