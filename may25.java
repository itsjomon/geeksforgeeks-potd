class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int sq=arr[i]*arr[i];
            set.add(sq);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int k=arr[i]*arr[i]+arr[j]*arr[j];
                if(set.contains(k)) return true;
            }
        }
        return false;
    }
}
