import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N + 1];
//정렬생략
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                arr[doc] = interview;
            }

            int cnt = 1;
            int minInterview = arr[1];

            for (int i = 2; i <= N; i++) {
                if (arr[i] < minInterview) {
                    minInterview = arr[i];
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
