import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        for (long i = 1; i <= N; i++) {
            sum += i * (N / i);
        }
        System.out.println(sum);
    }
}