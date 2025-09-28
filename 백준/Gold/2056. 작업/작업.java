import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];
        int[] indeg = new int[N + 1];
        int[] dp = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                dp[nxt] = Math.max(dp[nxt], dp[cur] + time[nxt]);
                indeg[nxt]--;
                if (indeg[nxt] == 0) q.offer(nxt);
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) ans = Math.max(ans, dp[i]);
        System.out.println(ans);
    }
}
