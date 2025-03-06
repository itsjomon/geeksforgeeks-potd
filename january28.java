class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        do res.add(new String(chars));
        while (next(chars));
        return res;
    }

    private boolean next(char[] c) {
        int i = c.length - 2, j = c.length - 1;
        while (i >= 0 && c[i] >= c[i + 1]) i--;
        if (i < 0) return false;
        while (c[j] <= c[i]) j--;
        char t = c[i]; c[i] = c[j]; c[j] = t;
        for (int l = i + 1, r = c.length - 1; l < r; l++, r--) {
            t = c[l]; c[l] = c[r]; c[r] = t;
        }
        return true;
    }
}
