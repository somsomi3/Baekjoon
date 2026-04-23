class Solution {
    public int solution(int[][] a, int[][] s) {
        int n = a.length, m = a[0].length;
        int[][] d = new int[n + 2][m + 2];

        for (int[] x : s) {
            int v = x[5] * (x[0] == 1 ? -1 : 1);

            d[x[1]][x[2]] += v;
            d[x[1]][x[4] + 1] -= v;
            d[x[3] + 1][x[2]] -= v;
            d[x[3] + 1][x[4] + 1] += v;
        }

        // 세로 먼저
        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= m; j++)
                d[i][j] += d[i - 1][j];

        // 가로
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++)
                d[i][j] += d[i][j - 1];

        int ans = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] + d[i][j] > 0) ans++;

        return ans;
    }
}