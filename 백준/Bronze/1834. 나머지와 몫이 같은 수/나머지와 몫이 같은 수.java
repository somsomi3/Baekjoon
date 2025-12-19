import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        for (long k = 1; k < N; k++) {
            sum += k * (N + 1);
        }

        System.out.println(sum);
    }
}