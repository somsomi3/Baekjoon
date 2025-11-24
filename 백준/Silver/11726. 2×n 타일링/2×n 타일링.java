import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) { 
            System.out.println(1);
            return;
        }

        int a = 1;  // dp[1]
        int b = 2;  // dp[2]

        for (int i = 3; i <= N; i++) {
            int c = (a + b) % 10007;
            a = b;
            b = c;
        }

        System.out.println(b);
    }
}
