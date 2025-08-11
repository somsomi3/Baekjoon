import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                Integer val = maxHeap.poll();
                sb.append(val == null ? 0 : val).append('\n');
            } else {
                maxHeap.offer(x);
            }
        }
        System.out.print(sb);
    }
}
