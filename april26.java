class Solution {
    int c(Node r){return r==null?0:1+c(r.left)+c(r.right);}
    boolean p(Node r,int i,int n){
        return r==null
            || (i<n
                && (r.left  ==null || r.data>=r.left.data)
                && (r.right ==null || r.data>=r.right.data)
                &&  p(r.left,  2*i+1, n)
                &&  p(r.right, 2*i+2, n)
               );
    }
    boolean isHeap(Node tree){
        return p(tree,0,c(tree));
    }
}
