class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1, high = 0;
        for (int a : arr) high = Math.max(high, a);
        
        while (low < high) {
            int mid = (low + high) / 2;
            int hours = 0;
            for (int a : arr) hours += (a + mid - 1) / mid;
            if (hours > k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
