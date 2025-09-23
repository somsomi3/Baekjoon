import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
        Arrays.sort(coins); // 오름차순 정렬

        int count = 0;
        for (int i = N - 1; i >= 0 && K > 0; i--) {
            count += K / coins[i];
            K %= coins[i];
        }

        System.out.println(count);
    }
}
