import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        int[] cnt = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;
        cnt[N] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                if (nx < 0 || nx > MAX) continue;

                if (dist[nx] == -1) { 
                    dist[nx] = dist[x] + 1;
                    cnt[nx] = cnt[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) { 
                    cnt[nx] += cnt[x];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}
