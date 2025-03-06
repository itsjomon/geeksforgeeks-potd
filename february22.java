class Solution {
    static int maxLength(String s) {
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(-1);
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                st.pop();
                if (st.empty()) st.push(i);
                else m = Math.max(m, i - st.peek());
            }
        }
        return m;
    }
}
