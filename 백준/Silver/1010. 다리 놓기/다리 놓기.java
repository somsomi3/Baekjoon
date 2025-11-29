import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        // 조합 표 (파스칼 삼각형) 미리 계산: 0..30
        long[][] C = new long[31][31];
        for (int n = 0; n <= 30; n++) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; k++) {
                C[n][k] = C[n-1][k-1] + C[n-1][k];
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 서쪽
            int m = Integer.parseInt(st.nextToken()); // 동쪽
            sb.append(C[m][n]).append('\n'); // 동쪽에서 n개 선택
        }
        System.out.print(sb);
    }
}
