import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        //정점 자체의 visited, dist
        boolean[] visited = new boolean[MAX];
        
        //dist[x] : N에서 x까지 걸린 최소 시간
        int[] dist = new int[MAX];

        //BFS
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            //현재 위치에서 갈 수 있는 3가지 이동 정의
            //방향벡터 같은 역할
            // 최단거리 보장
            int[] next = {cur - 1, cur + 1, cur * 2};

            for (int nx : next) {
                if (nx >= 0 && nx < MAX && !visited[nx]) {//범위 안에 있고, 방문하지 않았다면
                    visited[nx] = true;
                    dist[nx] = dist[cur] + 1;
                    q.offer(nx);
                }
            }
        }
    }

}