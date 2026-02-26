import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        long a = 0;
        int mx = 0;

        for (long k : m.keySet()) {
            int c = m.get(k);

            if (c > mx) {
                mx = c;
                a = k;
            } else if (c == mx && k < a) {
                a = k;
            }
        }

        System.out.println(a);
    }
}