import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] q, s, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        q = new int[N];
        s = new int[N];
        b = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 123; i <= 987; i++) {
            String cur = String.valueOf(i);

            if (cur.contains("0")) continue;
            if (cur.charAt(0) == cur.charAt(1)) continue;
            if (cur.charAt(1) == cur.charAt(2)) continue;
            if (cur.charAt(0) == cur.charAt(2)) continue;

            boolean ok = true;

            for (int j = 0; j < N; j++) {
                String target = String.valueOf(q[j]);

                int sc = 0, bc = 0;

                for (int a = 0; a < 3; a++) {
                    for (int c = 0; c < 3; c++) {
                        if (cur.charAt(a) == target.charAt(c)) {
                            if (a == c) sc++;
                            else bc++;
                        }
                    }
                }

                if (sc != s[j] || bc != b[j]) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans++;
        }

        System.out.println(ans);
    }
}