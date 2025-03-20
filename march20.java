class Solution {
    public static int maxProfit(int[] a) {
        int b1 = Integer.MAX_VALUE, s1 = 0, b2 = Integer.MAX_VALUE, s2 = 0;
        for (int p : a) {
            b1 = Math.min(b1, p);
            s1 = Math.max(s1, p - b1);
            b2 = Math.min(b2, p - s1);
            s2 = Math.max(s2, p - b2);
        }
        return s2;
    }
}
