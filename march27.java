class Solution {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, cnt = 0, ans = 0, n = arr.length;
        while(i < n && j < n)
            if(arr[i] <= dep[j]) { cnt++; ans = Math.max(ans, cnt); i++; }
            else { cnt--; j++; }
        return ans;
    }
}
