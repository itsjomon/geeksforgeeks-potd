class Solution {
    public void floydWarshall(int[][] d) {
        int n = d.length, inf = 100000000;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (d[i][k] < inf && d[k][j] < inf && d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];
    }
}
