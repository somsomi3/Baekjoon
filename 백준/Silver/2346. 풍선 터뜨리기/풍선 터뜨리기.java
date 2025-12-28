import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            dq.addLast(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            
            sb.append(cur[0]).append(" ");
            int move = cur[1];

            if (dq.isEmpty()) break;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb.toString().trim());
    }
}
