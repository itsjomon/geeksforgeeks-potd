class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= arr.length - k; i--) res.add(arr[i]);
        return res;
    }
}
