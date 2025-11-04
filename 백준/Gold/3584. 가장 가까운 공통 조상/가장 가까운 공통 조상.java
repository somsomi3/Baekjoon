import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            parent = new int[N + 1];
            visited = new boolean[N + 1];
            boolean[] isChild = new boolean[N + 1];

            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                isChild[b] = true;
            }

            int root = 1;
            for (int i = 1; i <= N; i++) {
                if (!isChild[i]) {
                    root = i;
                    break;
                }
            }

            dfs(root);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] check = new boolean[N + 1];
            while (a != 0) {
                check[a] = true;
                a = parent[a];
            }

            while (b != 0) {
                if (check[b]) {
                    sb.append(b).append('\n');
                    break;
                }
                b = parent[b];
            }
        }

        System.out.print(sb.toString());
    }

    static void dfs(int cur) {
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (!visited[next]) {
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}
