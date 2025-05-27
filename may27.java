class Solution {
    int index = 0;
    int[] leafBuffer = new int[1000];
    int leafCount = 0;
    
    public ArrayList<Integer> leafNodes(int[] preorder) {
        index = 0;
        leafCount = 0;
        findLeaves(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < leafCount; i++) {
            result.add(leafBuffer[i]);
        }
        return result;
    }

    void findLeaves(int[] preorder, int min, int max) {
        if (index >= preorder.length) return;
        
        int val = preorder[index];
        if (val < min || val > max) return;
        
        index++;
        int currIndex = index;
        
        findLeaves(preorder, min, val);
        findLeaves(preorder, val, max);
        
        if (index == currIndex) {
            leafBuffer[leafCount++] = val;
        }
    }
}
