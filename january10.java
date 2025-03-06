class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (i >= k - 1) {
                res.add(freq.size());
                freq.put(arr[i - k + 1], freq.get(arr[i - k + 1]) - 1);
                if (freq.get(arr[i - k + 1]) == 0) freq.remove(arr[i - k + 1]);
            }
        }
        return res;
    }
}
