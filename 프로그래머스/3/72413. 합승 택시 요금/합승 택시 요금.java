import java.util.*;

class Solution {
    static final int INF = 100000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int cost = fare[2];

            dist[x][y] = cost;
            dist[y][x] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

                }
            }
        }

        int answer = INF;

        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer,
                    dist[s][k] + dist[k][a] + dist[k][b]);
        }
        return answer;
    }
}