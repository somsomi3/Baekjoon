import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] last = new int[n + 1];
            int[] rank = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                last[i] = Integer.parseInt(st.nextToken());
                rank[last[i]] = i;
            }

            boolean[][] adj = new boolean[n + 1][n + 1];
            int[] indeg = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int a = last[i], b = last[j];
                    adj[a][b] = true;
                    indeg[b]++;
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

            List<Integer> res = new ArrayList<>();
            boolean impossible = false, uncertain = false;

            for (int i = 0; i < n; i++) {
                if (q.isEmpty()) { impossible = true; break; }
                if (q.size() > 1) uncertain = true;
                int u = q.poll();
                res.add(u);
                for (int v = 1; v <= n; v++) {
                    if (adj[u][v]) {
                        if (--indeg[v] == 0) q.offer(v);
                    }
                }
            }

            if (impossible) sb.append("IMPOSSIBLE\n");
            else if (uncertain) sb.append("?\n");
            else {
                for (int x : res) sb.append(x).append(' ');
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
