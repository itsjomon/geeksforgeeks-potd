class Solution {
    public int maxXor(int[] arr) {
        int maxXor = 0, mask = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            set.clear();
            int temp = maxXor | (1 << i);
            boolean found = false;
            for (int num : arr) {
                int prefix = num & mask;
                if (set.contains(temp ^ prefix)) {
                    found = true;
                    break;
                }
                set.add(prefix);
            }
            if (found) maxXor = temp;
        }
        return maxXor;
    }
}
