class Solution {
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    public void pop() {
        if (!s.isEmpty()) {
            if (s.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            s.pop();
        }
    }
    public int peek() {
        return s.isEmpty() ? -1 : s.peek();
    }
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
