import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 전체 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()); // 시작 사람
        B = Integer.parseInt(st.nextToken()); // 도착 사람

        M = Integer.parseInt(br.readLine()); // 관계 개수
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 관계 입력 받기 (양방향 연결)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // BFS 탐색 시작
        bfs(A);

        System.out.println(dist[B] == 0 ? -1 : dist[B]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1; // 촌수 증가
                    q.offer(next);
                }
            }
        }
    }
}
