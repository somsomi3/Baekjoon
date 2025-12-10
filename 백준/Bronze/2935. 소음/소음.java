import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String op = br.readLine();
        String B = br.readLine();

        if (op.equals("*")) {
            int zeros = (A.length() - 1) + (B.length() - 1);
            StringBuilder sb = new StringBuilder("1");
            for (int i = 0; i < zeros; i++) sb.append("0");
            System.out.println(sb);
        } else {
            if (A.length() == B.length()) {
                // 예: 1000 + 1000 = 2000
                System.out.println("2" + A.substring(1));
            } else {
                // 예: 1000 + 100 = 1100
                // 더 큰 숫자를 기준으로 처리
                String big = A.length() > B.length() ? A : B;
                String small = A.length() > B.length() ? B : A;
                StringBuilder sb = new StringBuilder(big);
                sb.setCharAt(big.length() - small.length(), '1');
                System.out.println(sb);
            }
        }
    }
}
