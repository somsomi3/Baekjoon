import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = arr[0];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int g = gcd(first, arr[i]);
            sb.append(first / g)
              .append("/")
              .append(arr[i] / g)
              .append("\n");
        }

        System.out.print(sb.toString());
    }
}
