import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(dist[K]).append('\n');

        List<Integer> path = new ArrayList<>();
        for (int i = K; i != N; i = parent[i]) {
            path.add(i);
        }
        path.add(N);
        Collections.reverse(path);

        for (int x : path) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
        
    }
    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) return;

            //탐색순서주의 
            int[] nexts = {cur * 2, cur - 1, cur + 1};

            for (int next : nexts) {
                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;

                visited[next] = true;
                dist[next] = dist[cur] + 1;
                parent[next] = cur;
                q.offer(next);
            }
        }
    }
}