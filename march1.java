class Solution {
    static String decodeString(String s) {
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String cur = "";
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) n = n * 10 + (c - '0');
            else if (c == '[') { str.push(cur); num.push(n); cur = ""; n = 0; }
            else if (c == ']') {
                String temp = cur;
                cur = str.pop();
                cur += temp.repeat(num.pop());
            } else cur += c;
        }
        return cur;
    }
}
