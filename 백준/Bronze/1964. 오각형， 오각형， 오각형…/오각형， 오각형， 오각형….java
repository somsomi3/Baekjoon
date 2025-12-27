import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mod = 45678;

        if (N == 1) {
            System.out.println(5);
            return;
        }

        int result = 5;
        int add = 7;

        for (int i = 2; i <= N; i++) {
            result = (result + add) % mod;
            add += 3;
        }

        System.out.println(result);
    }
}
