import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[N+1];
        for (int i=1; i<=N; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i=K; i<=N; i++) {
            int sum = prefix[i] - prefix[i-K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
