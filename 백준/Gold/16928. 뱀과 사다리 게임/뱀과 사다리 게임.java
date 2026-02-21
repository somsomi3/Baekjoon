import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == 100) return cnt;

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;

                if (next > 100) continue;

                if (board[next] != 0) {
                    next = board[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }
}