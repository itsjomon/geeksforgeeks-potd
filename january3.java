class Solution {
    public long subarrayXor(int[] arr, int k) {
        long res = 0, prefXOR = 0;
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);  
        for (int val : arr) {
            prefXOR ^= val; 
            res += mp.getOrDefault(prefXOR ^ k, 0); 
            mp.put(prefXOR, mp.getOrDefault(prefXOR, 0) + 1); 
        }
        
        return res;
    }
}
