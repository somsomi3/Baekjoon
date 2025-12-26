import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        BigInteger min = A.min(B);
        BigInteger max = A.max(B);

        BigInteger n = max.subtract(min).add(BigInteger.ONE);
        BigInteger sum = min.add(max).multiply(n).divide(BigInteger.valueOf(2));

        System.out.println(sum);
    }
}
