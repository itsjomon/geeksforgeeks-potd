class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(String s, int start, ArrayList<String> temp, ArrayList<ArrayList<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String part = s.substring(start, i);
            if (isPalin(part)) {
                temp.add(part);
                backtrack(s, i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
