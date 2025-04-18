class Trie {
    class N { N[] c = new N[26]; boolean e; }
    N r = new N();
    public void insert(String w) {
        N n = r;
        for (char ch : w.toCharArray())
            n = n.c[ch - 'a'] != null ? n.c[ch - 'a'] : (n.c[ch - 'a'] = new N());
        n.e = true;
    }
    public boolean search(String w) {
        N n = r;
        for (char ch : w.toCharArray())
            if ((n = n.c[ch - 'a']) == null) return false;
        return n.e;
    }
    public boolean isPrefix(String w) {
        N n = r;
        for (char ch : w.toCharArray())
            if ((n = n.c[ch - 'a']) == null) return false;
        return true;
    }
}
