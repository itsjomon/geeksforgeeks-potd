class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] towers = new int[n][2];
        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }

        Arrays.sort(towers, Comparator.comparingInt(a -> a[0]));

        long[] prefixCost = new long[n];
        prefixCost[0] = towers[0][1];
        for (int i = 1; i < n; i++) {
            prefixCost[i] = prefixCost[i - 1] + towers[i][1];
        }

        long totalCost = 0;
        for (int i = 1; i < n; i++) {
            totalCost += (long) towers[i][1] * (towers[i][0] - towers[0][0]);
        }

        long result = totalCost;
        for (int i = 1; i < n; i++) {
            int gap = towers[i][0] - towers[i - 1][0];
            totalCost += (long) prefixCost[i - 1] * gap;
            totalCost -= (long) (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            result = Math.min(result, totalCost);
        }

        return (int) result;
    }
}
