import java.io.*;

public class Main {
    static String S, T;
    static boolean ok = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(ok ? 1 : 0);
    }

    static void dfs(String cur) {
        if (ok) return;

        if (cur.length() == S.length()) {
            if (cur.equals(S)) ok = true;
            return;
        }

        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }

        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
