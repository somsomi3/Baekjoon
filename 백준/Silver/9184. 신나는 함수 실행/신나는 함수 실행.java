import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp = new int[21][21][21];
    static int func(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return func(20, 20, 20);
        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            return dp[a][b][c] = func(a, b, c - 1)
                    + func(a, b - 1, c - 1)
                    - func(a, b - 1, c);
        }
        return dp[a][b][c] = func(a - 1, b, c)
                + func(a - 1, b - 1, c)
                + func(a - 1, b, c - 1)
                - func(a - 1, b - 1, c - 1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            result.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                    .append(") = ").append(func(a, b, c)).append("\n");
        }
        System.out.print(result);
    }
}