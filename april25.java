class Solution {
    static int majorityElement(int[] a) {
        int cand=0, count=0;
        for (int v : a) {
            if (count == 0) cand = v;
            count += v == cand ? 1 : -1;
        }
        count = 0;
        for (int v : a) if (v == cand) count++;
        return count > a.length / 2 ? cand : -1;
    }
}
