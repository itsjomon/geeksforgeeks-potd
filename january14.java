class Solution {
    public static int findEquilibrium(int[] arr) {
        long sum = Arrays.stream(arr).asLongStream().sum(), sum2 = 0;
        for (int i = 0; i < arr.length; sum2 += arr[i++])
            if ((sum -= arr[i]) == sum2) return i;
        return -1;
    }
}
