class Tree {
    public ArrayList<Integer> serialize(Node r) {
        ArrayList<Integer> a = new ArrayList<>();
        s(r, a);
        return a;
    }
    void s(Node r, ArrayList<Integer> a) {
        if(r==null){a.add(-1); return;}
        a.add(r.data);
        s(r.left, a);
        s(r.right, a);
    }
    public Node deSerialize(ArrayList<Integer> a) {
        int[] i = {0};
        return d(a, i);
    }
    Node d(ArrayList<Integer> a, int[] i) {
        if(i[0]>=a.size() || a.get(i[0])==-1){i[0]++; return null;}
        Node r = new Node(a.get(i[0]++));
        r.left = d(a, i);
        r.right = d(a, i);
        return r;
    }
}
