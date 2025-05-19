class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null, curr = root;
        while (curr != null) {
            if (curr.data < key) {
                pre = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        curr = root;
        while (curr != null) {
            if (curr.data > key) {
                suc = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }
}
