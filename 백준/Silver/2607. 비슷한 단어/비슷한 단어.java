import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String t = br.readLine();

        int[] cnt = new int[26];
        for (char c : t.toCharArray()) {
            cnt[c - 'A']++;
        }

        int ans = 0;

        for (int i = 1; i < N; i++) {
            String s = br.readLine();
            int[] cur = new int[26];

            for (char c : s.toCharArray()) {
                cur[c - 'A']++;
            }

            int p = 0;
            int m = 0;

            for (int j = 0; j < 26; j++) {
                int chae = cur[j] - cnt[j];
                if (chae > 0) p += chae;
                else m -= chae;
            }

            if (p <= 1 && m <= 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}