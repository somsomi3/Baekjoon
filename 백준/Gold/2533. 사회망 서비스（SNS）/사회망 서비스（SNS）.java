import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[][] dp;
    static SNS[] sns; // 연결리스트 형태로 그래프 표현

    static class SNS {
        int to;
        SNS next;

        SNS(int to, SNS next) {
            this.to = to;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        sns = new SNS[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sns[a] = new SNS(b, sns[a]); // a → b 연결
            sns[b] = new SNS(a, sns[b]); // b → a 연결
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int cur) {
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (SNS next = sns[cur]; next != null; next = next.next) {
            if (!visited[next.to]) {
                dfs(next.to);
                dp[cur][0] += dp[next.to][1];
                dp[cur][1] += Math.min(dp[next.to][0], dp[next.to][1]);
            }
        }
    }
}
