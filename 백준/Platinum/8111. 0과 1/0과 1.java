import java.util.*;

public class Main {
    static int[] parent = new int[20001];
    static int[] how = new int[20001];
    static boolean[] visited = new boolean[20001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            bfs(N);
        }
    }

    static void bfs(int N) {
        Arrays.fill(parent, -1);
        Arrays.fill(how, -1);
        Arrays.fill(visited, false);

        Queue<Integer> q = new LinkedList<>();
        q.offer(1 % N);
        visited[1 % N] = true;
        parent[1 % N] = -1;
        how[1 % N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 0) {
                printAnswer(cur);
                return;
            }

            for (int d = 0; d <= 1; d++) {
                int next = (cur * 10 + d) % N;
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    how[next] = d;
                    q.offer(next);
                }
            }
        }
    }

    static void printAnswer(int cur) {
        StringBuilder sb = new StringBuilder();
        while (cur != -1) {
            sb.append(how[cur]);
            cur = parent[cur];
        }
        System.out.println(sb.reverse());
    }
}
