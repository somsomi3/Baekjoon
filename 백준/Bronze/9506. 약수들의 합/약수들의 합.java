import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 0;
            List<Integer> list = new ArrayList<>();

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    int a = i;
                    int b = n / i;

                    if (a != n) {
                        list.add(a);
                        sum += a;
                    }

                    if (b != a && b != n) {
                        list.add(b);
                        sum += b;
                    }
                }
            }

            Collections.sort(list);

            if (sum == n) {
                StringBuilder sb = new StringBuilder();
                sb.append(n).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i < list.size() - 1) sb.append(" + ");
                }
                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
