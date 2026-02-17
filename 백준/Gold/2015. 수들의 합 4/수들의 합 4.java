import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        long sum = 0;
        long answer = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];

            if (map.containsKey(sum - K)) {
                answer += map.get(sum - K);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(answer);
    }
}