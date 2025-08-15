import java.io.*;

public class Main {
    static int N, M, count;
    static boolean[][] graph;
    static boolean[] visited;

    // 빠른 입력
    static int read() throws IOException {
        int c, n = System.in.read() & 15; // 첫 숫자
        while ((c = System.in.read()) > 32) // 공백 전까지
            n = (n << 3) + (n << 1) + (c & 15); // n*10 + digit
        return n;
    }

    static void dfs(int node) {
        visited[node] = true;
        count++;
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = read();
        M = read();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            graph[a][b] = graph[b][a] = true;
        }

        dfs(1); // 1번 컴퓨터에서 시작
        System.out.println(count - 1); // 자기 자신 제외
    }
}
