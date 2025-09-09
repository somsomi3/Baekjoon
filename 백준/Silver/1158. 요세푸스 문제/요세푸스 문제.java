import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append('<');

        int idx = 0;
        while (!list.isEmpty()) {
            idx = (idx + K - 1) % list.size();
            sb.append(list.remove(idx));

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append('>');
        System.out.println(sb);
    }
}
