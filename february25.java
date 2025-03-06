class Solution {
    public int getMaxArea(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length, res = 0;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && (i == n || arr[s.peek()] >= arr[i])) {
                int h = arr[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                res = Math.max(res, h * w);
            }
            s.push(i);
        }
        return res;
    }
}
