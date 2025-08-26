import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int OFFSET = 10_000_000;
        final int SIZE = 20_000_001;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[SIZE]; // -10_000_000 ~ 10_000_000

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            count[num + OFFSET]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            sb.append(count[query + OFFSET]).append(' ');
        }

        System.out.println(sb);
    }
}
