import java.io.*;

public class Main {

    static boolean isPrime(long x) {
        if (x == 2) return true;
        if (x < 2 || x % 2 == 0) return false;

        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());

            if (n <= 2) n = 2;
            else if (n % 2 == 0) n++;  // 짝수면 바로 홀수로

            while (!isPrime(n)) {
                n += 2;               // 홀수만 검사
            }

            sb.append(n).append('\n');
        }

        System.out.print(sb);
    }
}