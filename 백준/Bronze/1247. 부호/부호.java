import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;

            for (int i = 0; i < N; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            int cmp = sum.compareTo(BigInteger.ZERO);
            if (cmp > 0) System.out.println("+");
            else if (cmp < 0) System.out.println("-");
            else System.out.println("0");
        }
    }
}
