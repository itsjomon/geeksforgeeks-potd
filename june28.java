class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        int n = a.length, m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        int[] cnt = new int[100001];
        for (int i = 0; i < 100001; i++) {
            cnt[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            cnt[b[i]]++;
        }
        for (int i = 1; i < 100001; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < n; i++) {
            res.set(i, cnt[a[i]]);
        }

        return res;
    }
}
