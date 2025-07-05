import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tunnel implements Comparable<Tunnel> {
        int from, to, price;

        public Tunnel(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }

        @Override
        public int compareTo(Tunnel o) {
            return this.price - o.price;
        }
    }

    static PriorityQueue<Tunnel> tunnels;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] planets = new int[N][4]; // x,y,z,index

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            planets[i][0] = Integer.parseInt(st.nextToken()); // x
            planets[i][1] = Integer.parseInt(st.nextToken()); // y
            planets[i][2] = Integer.parseInt(st.nextToken()); // z
            planets[i][3] = i; // index
        }

        tunnels = new PriorityQueue<>();
        initTunnels(planets, N);

        parents = new int[N];
        for (int i = 0; i < N; i++) parents[i] = i;

        int cost = 0, cnt = 0;

        while (!tunnels.isEmpty()) {
            Tunnel cur = tunnels.poll();
            if (union(cur.from, cur.to)) {
                cost += cur.price;
                cnt++;
                if (cnt == N - 1) break;
            }
        }
        System.out.println(cost);
    }

    private static void initTunnels(int[][] planets, int N) {
        for (int dim = 0; dim < 3; dim++) {
            final int d = dim;
            Arrays.sort(planets, Comparator.comparingInt(p -> p[d]));

            for (int i = 0; i < N - 1; i++) {
                int[] a = planets[i];
                int[] b = planets[i + 1];
                int price = Math.min(
                        Math.min(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1])),
                        Math.abs(a[2] - b[2])
                );
                tunnels.offer(new Tunnel(a[3], b[3], price));
            }
        }
    }

    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }
}
