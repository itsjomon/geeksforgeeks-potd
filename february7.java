class Solution {
    ArrayList<Integer> inOrder(Node r) {
        ArrayList<Integer> a = new ArrayList<>();
        f(r, a);
        return a;
    }
    void f(Node r, ArrayList<Integer> a) {
        if (r == null) return;
        f(r.left, a);
        a.add(r.data);
        f(r.right, a);
    }
}
