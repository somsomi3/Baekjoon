
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];

        dfs(1, 0);

        if (result % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static void dfs(int node, int depth) {
        visited[node] = true;

        boolean isLeaf = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                isLeaf = false;
                dfs(next, depth + 1);
            }
        }

        if (isLeaf) {
            result += depth;
        }
    }
}