import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int max = sum;

        for (int i = 1; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            sum = Math.max(x, sum + x);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
