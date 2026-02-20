import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long D = 4 * N - 3;
        long sqrt = (long)Math.sqrt(D);

        if (sqrt * sqrt == D) {
            System.out.println((sqrt - 1) / 2);
        }
    }
}