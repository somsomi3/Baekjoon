import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s  = br.readLine();

        BigInteger num = new BigInteger(s, 2);   // 이진수 → BigInteger
        BigInteger result = num.multiply(BigInteger.valueOf(17)); // × 17

        System.out.println(result.toString(2)); // 다시 이진수로 출력
    }
}