class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            int days = 1;
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                days += span.get(st.pop());
            }
            span.add(days);
            st.push(i);
        }
        return span;
    }
}
