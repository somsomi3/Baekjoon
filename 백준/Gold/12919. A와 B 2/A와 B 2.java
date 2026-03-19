import java.io.*;

public class Main {
    static String S, T;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        System.out.println(result);
    }

    static void dfs(String T) {
        if (T.length() == S.length()) {
            if (T.equals(S)) result = 1;
            return;
        }
        if (T.charAt(T.length() - 1) == 'A') {
            dfs(T.substring(0, T.length() - 1));
        }
        if (T.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(T);
            sb.reverse();
            dfs(sb.substring(0, sb.length() - 1));
        }
    }
}