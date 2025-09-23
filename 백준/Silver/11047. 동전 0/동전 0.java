import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //인티저는 객체형이라 Collections.reverseOrder적용가능!
        Integer[] coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins, Collections.reverseOrder()); // 내림차순 정렬

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (coins[i] <= K) {
                count += K / coins[i];
                K %= coins[i];
            }
        }

        System.out.println(count);
    }
}
