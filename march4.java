class Solution {
    public int lis(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : arr) {
            int idx = Collections.binarySearch(ans, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == ans.size()) ans.add(num);
            else ans.set(idx, num);
        }
        return ans.size();
    }
}
