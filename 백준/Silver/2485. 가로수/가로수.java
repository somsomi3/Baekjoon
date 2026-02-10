import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int g = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            cnt += (arr[i + 1] - arr[i]) / g - 1;
        }

        System.out.println(cnt);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
