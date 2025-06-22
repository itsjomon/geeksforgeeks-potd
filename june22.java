class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) dp.add(new ArrayList<>());

        List<Integer> best = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> maxSubset = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    List<Integer> candidate = new ArrayList<>(dp.get(j));
                    candidate.add(arr[i]);
                    if (candidate.size() > maxSubset.size() || 
                       (candidate.size() == maxSubset.size() && isLexGreater(candidate, maxSubset))) {
                        maxSubset = candidate;
                    }
                }
            }
            if (maxSubset.isEmpty()) {
                dp.get(i).add(arr[i]);
            } else {
                dp.get(i).addAll(maxSubset);
            }

            if (dp.get(i).size() > best.size() ||
               (dp.get(i).size() == best.size() && isLexGreater(dp.get(i), best))) {
                best = new ArrayList<>(dp.get(i));
            }
        }

        Collections.sort(best);
        return new ArrayList<>(best);
    }

    private boolean isLexGreater(List<Integer> a, List<Integer> b) {
        List<Integer> x = new ArrayList<>(a), y = new ArrayList<>(b);
        Collections.sort(x);
        Collections.sort(y);
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i) > y.get(i)) return true;
            if (x.get(i) < y.get(i)) return false;
        }
        return false;
    }
}
