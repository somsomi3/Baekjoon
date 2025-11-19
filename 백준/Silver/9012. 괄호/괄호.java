import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            int cnt = 0;
            boolean ok = true;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '(') cnt++;
                else cnt--;

                if (cnt < 0) { 
                    ok = false;
                    break;
                }
            }

            if (cnt != 0) ok = false;

            sb.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }
}
