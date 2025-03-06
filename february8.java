class Solution {
    void lb(Node r, ArrayList<Integer> v) {
        if(r==null || (r.left==null && r.right==null)) return;
        v.add(r.data);
        lb(r.left!=null ? r.left : r.right, v);
    }
    void rb(Node r, ArrayList<Integer> v) {
        if(r==null || (r.left==null && r.right==null)) return;
        rb(r.right!=null ? r.right : r.left, v);
        v.add(r.data);
    }
    void leaf(Node r, ArrayList<Integer> v) {
        if(r==null)return;
        leaf(r.left,v);
        if(r.left==null && r.right==null) v.add(r.data);
        leaf(r.right,v);
    }
    public ArrayList<Integer> boundaryTraversal(Node r) {
        ArrayList<Integer> v = new ArrayList<>();
        if(r==null)return v;
        v.add(r.data);
        lb(r.left, v);
        leaf(r.left, v);
        leaf(r.right, v);
        rb(r.right, v);
        return v;
    }
}
