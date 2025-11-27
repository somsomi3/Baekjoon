import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];

    static boolean canMake(int num) {
        if (num == 0) return !broken[0];
        while (num > 0) {
            if (broken[num % 10]) return false;
            num /= 10;
        }
        return true;
    }

    static int len(int num) {
        if (num == 0) return 1;
        int cnt = 0;
        while (num > 0) {
            cnt++;
            num /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            if (!canMake(i)) continue;
            int press = len(i) + Math.abs(i - N);
            ans = Math.min(ans, press);
        }

        System.out.println(ans);
    }
}
