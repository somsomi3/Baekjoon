import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int idx = -1;
        int cnt = 0;

        for (int i = 0; i < N - 1; i++) {
            if (a[i] > a[i + 1]) {
                cnt++;
                idx = i;
            }
        }

        if (cnt == 0) {
            System.out.println(N);
            return;
        }

        if (cnt >= 2) {
            System.out.println(0);
            return;
        }

        int ans = 0;

        //내림 발생 앞부분의 앞뒤 비교
        if (idx == 0 || a[idx - 1] <= a[idx + 1]) {
            ans++;
        }

        //내림 발생 뒷부분의 앞뒤 비교
        if (idx + 1 == N - 1 || a[idx] <= a[idx + 2]) {
            ans++;
        }

        System.out.println(ans);
    }

}