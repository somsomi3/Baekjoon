import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] indeg = new int[n + 1];
            boolean[][] adj = new boolean[n + 1][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] last = new int[n + 1];
            for (int i = 1; i <= n; i++) last[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    adj[last[i]][last[j]] = true;
                    indeg[last[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (adj[a][b]) {
                    adj[a][b] = false;
                    adj[b][a] = true;
                    indeg[b]--;
                    indeg[a]++;
                } else {
                    adj[b][a] = false;
                    adj[a][b] = true;
                    indeg[a]--;
                    indeg[b]++;
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) if (indeg[i] == 0) q.offer(i);

            List<Integer> result = new ArrayList<>();
            boolean certain = true, impossible = false;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) {
                    impossible = true;
                    break;
                }
                if (q.size() > 1) certain = false;
                int cur = q.poll();
                result.add(cur);
                for (int j = 1; j <= n; j++) {
                    if (adj[cur][j]) {
                        indeg[j]--;
                        if (indeg[j] == 0) q.offer(j);
                    }
                }
            }

            if (impossible) sb.append("IMPOSSIBLE\n");
            else if (!certain) sb.append("?\n");
            else {
                for (int x : result) sb.append(x).append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
