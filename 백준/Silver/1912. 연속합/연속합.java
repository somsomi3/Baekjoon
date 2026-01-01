import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cur = Integer.parseInt(st.nextToken());
        int ans = cur;

        for (int i = 1; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            cur = Math.max(x, cur + x);
            ans = Math.max(ans, cur);
        }

        System.out.println(ans);
    }
}
