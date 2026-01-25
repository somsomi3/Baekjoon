import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static char[] sign;
    static boolean[] used = new boolean[10];
    static String min = null, max = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        sign = new char[K];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) sign[i] = st.nextToken().charAt(0);

        for (int i = 0; i <= 9; i++) {
            used[i] = true;
            dfs(0, String.valueOf(i));
            used[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, String cur) {
        if (idx == K) {
            if (min == null || cur.compareTo(min) < 0) min = cur;
            if (max == null || cur.compareTo(max) > 0) max = cur;
            return;
        }

        int prev = cur.charAt(cur.length() - 1) - '0';

        for (int next = 0; next <= 9; next++) {
            if (used[next]) continue;
            if (sign[idx] == '<' && prev >= next) continue;
            if (sign[idx] == '>' && prev <= next) continue;

            used[next] = true;
            dfs(idx + 1, cur + next);
            used[next] = false;
        }
    }
}