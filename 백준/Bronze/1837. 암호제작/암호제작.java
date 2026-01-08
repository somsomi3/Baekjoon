import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[K];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < K; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < K; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < K; i++) {
            if (isPrime[i]) {
                if (P.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }

        System.out.println("GOOD");
    }
}
