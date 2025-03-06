class Solution {
    public boolean isWordExist(char[][] b, String w) {
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                if (b[i][j] == w.charAt(0) && dfs(b, w, i, j, 0))
                    return true;
        return false;
    }

    private boolean dfs(char[][] b, String w, int i, int j, int k) {
        if (k == w.length()) return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(k)) return false;
        char t = b[i][j];
        b[i][j] = '#';
        boolean f = dfs(b, w, i - 1, j, k + 1) || dfs(b, w, i + 1, j, k + 1) ||
                   dfs(b, w, i, j - 1, k + 1) || dfs(b, w, i, j + 1, k + 1);
        b[i][j] = t;
        return f;
    }
}
