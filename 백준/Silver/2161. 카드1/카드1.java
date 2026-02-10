import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.add(i);

        StringBuilder sb = new StringBuilder();

        while (dq.size() > 1) {
            sb.append(dq.pollFirst()).append(" ");
            dq.addLast(dq.pollFirst());
        }

        sb.append(dq.poll());
        System.out.println(sb);
    }
}
