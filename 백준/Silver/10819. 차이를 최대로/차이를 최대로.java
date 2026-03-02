import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, p;
    static boolean[] v;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        p = new int[N];
        v = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int d) {
        if (d == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(p[i] - p[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) {
                v[i] = true;
                p[d] = arr[i];
                dfs(d + 1);
                v[i] = false;
            }
        }
    }
}