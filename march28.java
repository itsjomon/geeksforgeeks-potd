class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length, ans = 0, finishtime = -1;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> finish[i]));
        for (int i : indices) {
            if (start[i] > finishtime) {
                finishtime = finish[i];
                ans++;
            }
        }
        return ans;
    }
}
