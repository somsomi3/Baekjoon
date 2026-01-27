import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            char c = cmd.charAt(0);

            if (c == 'a') {
                if (cmd.charAt(1) == 'd') {
                    int x = Integer.parseInt(st.nextToken());
                    s.add(x);
                } else {
                    s.clear();
                    for (int x = 1; x <= 20; x++) s.add(x);
                }
            } else if (c == 'r') {
                int x = Integer.parseInt(st.nextToken());
                s.remove(x);
            } else if (c == 'c') {
                int x = Integer.parseInt(st.nextToken());
                sb.append(s.contains(x) ? 1 : 0).append('\n');
            } else if (c == 't') {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) s.remove(x);
                else s.add(x);
            } else if (c == 'e') {
                s.clear();
            }
        }

        System.out.print(sb.toString());
    }
}