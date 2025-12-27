import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPack = Integer.MAX_VALUE;
        int minSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, a);
            minSingle = Math.min(minSingle, b);
        }

        int ans = Math.min(
            N * minSingle,
            Math.min(
                (N / 6) * minPack + (N % 6) * minSingle,
                ((N + 5) / 6) * minPack
            )
        );

        System.out.println(ans);
    }
}
