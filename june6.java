class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int d = 256, q = 101;
        int M = pat.length(), N = txt.length();
        int p = 0, t = 0, h = 1;

        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;

        for (int i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= N - M; i++) {
            if (p == t) {
                int j = 0;
                while (j < M && txt.charAt(i + j) == pat.charAt(j)) j++;
                if (j == M) res.add(i + 1);
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) t += q;
            }
        }
        return res;
    }
}
