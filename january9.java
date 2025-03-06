class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int s = 0, curr = 0;
        for (int e = 0; e < arr.length; e++) {
            curr += arr[e];
            while (curr > target && s <= e) curr -= arr[s++];
            if (curr == target) return new ArrayList<>(Arrays.asList(s + 1, e + 1));
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
}
