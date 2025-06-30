import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 최대 힙 (왼쪽 절반, 가운데보다 작거나 같은 값들)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 (오른쪽 절반, 가운데보다 큰 값들)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // Step 1. maxHeap에 먼저 넣기
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Step 2. 균형 맞추기
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // Step 3. 현재 중간값 출력
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
