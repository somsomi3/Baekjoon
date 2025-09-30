import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[] prefix = new long[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) prefix[i] = prefix[i-1] + arr[i];
        long total = prefix[N-1];

        long ans = 0;

        // 1) 벌-벌-꿀통 (꿀통 오른쪽 끝)
        for (int i = 1; i < N-1; i++) {
            long val = (total - arr[0] - arr[i]) + (total - prefix[i]);
            ans = Math.max(ans, val);
        }

        // 2) 꿀통-벌-벌 (꿀통 왼쪽 끝)
        for (int i = 1; i < N-1; i++) {
            long val = (total - arr[N-1] - arr[i]) + prefix[i-1];
            ans = Math.max(ans, val);
        }

        // 3) 벌-꿀통-벌 (꿀통 중간)
        for (int i = 1; i < N-1; i++) {
            long val = (prefix[i] - arr[0]) + (total - prefix[i-1] - arr[N-1]);
            ans = Math.max(ans, val);
        }

        System.out.println(ans);
    }
}
