import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int minSum = K * (K + 1) / 2;
        if (N < minSum) {
            System.out.println(-1);
            return;
        }

        int remain = N - minSum;
        if (remain % K == 0) {
            System.out.println(K - 1);
        } else {
            System.out.println(K);
        }
    }
}
