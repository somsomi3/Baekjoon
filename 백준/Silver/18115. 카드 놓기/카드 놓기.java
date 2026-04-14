import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] skill = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            
            if (skill[i] == 1) {
                dq.addFirst(card);
            } else if (skill[i] == 2) {
                int first = dq.pollFirst();
                dq.addFirst(card);
                dq.addFirst(first);
            } else {
                dq.addLast(card);
            }
        }
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}