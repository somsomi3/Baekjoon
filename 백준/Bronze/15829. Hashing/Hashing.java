import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long M = 1234567891;
        long r = 1;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int value = s.charAt(i) - 'a' + 1;
            sum = (sum + value * r) % M;
            r = (r * 31) % M;
        }
        System.out.println(sum);
    }
}
