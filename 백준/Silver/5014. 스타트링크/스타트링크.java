import java.io.*;
import java.util.*;

public class Main {
    static int F,S,G,U,D;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        dist = new int[F+1];

        bfs();
        if (!visited[G]) System.out.println("use the stairs");
        else System.out.println(dist[G]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) return;
            
            int up = cur+U;
            int down = cur-D;
            
            if (up <= F && !visited[up]) {
                visited[up] = true;
                dist[up] = dist[cur] + 1;
                q.offer(up);
            }

            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                dist[down] = dist[cur] + 1;
                q.offer(down);
            }
        }
    }
}