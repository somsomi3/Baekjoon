import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[arr[i]] == 0) distinct++;
            cnt[arr[i]]++;
        }

        int ans = distinct + (cnt[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int remove = arr[i - 1];
            cnt[remove]--;
            if (cnt[remove] == 0) distinct--;

            int add = arr[(i + k - 1) % N];
            if (cnt[add] == 0) distinct++;
            cnt[add]++;

            ans = Math.max(ans, distinct + (cnt[c] == 0 ? 1 : 0));
        }

        System.out.println(ans);
    }
}
