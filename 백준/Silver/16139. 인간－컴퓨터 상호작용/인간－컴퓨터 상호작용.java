import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int Q = Integer.parseInt(br.readLine());

        int N = S.length();
        int[][] prefix = new int[N+1][26];

        for (int i=1; i<=N; i++) {
            int ch = S.charAt(i-1) - 'a';
            for (int j=0; j<26; j++) {
                prefix[i][j] = prefix[i-1][j];
            }
            prefix[i][ch]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int q=0; q<Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken()) + 1; // 1-based
            int r = Integer.parseInt(st.nextToken()) + 1;

            int idx = c - 'a';
            sb.append(prefix[r][idx] - prefix[l-1][idx]).append("\n");
        }
        System.out.print(sb);
    }
}
