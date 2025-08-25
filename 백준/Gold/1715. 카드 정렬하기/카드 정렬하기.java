import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;

        while (pq.size() > 1) {
            int a = pq.poll(); // 가장 작은 카드 묶음
            int b = pq.poll(); // 그 다음으로 작은 카드 묶음

            int sum = a + b;
            total += sum;

            pq.add(sum); // 합친 묶음을 다시 우선순위 큐에 넣기
        }

        System.out.println(total);
    }
}
